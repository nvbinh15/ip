package duke;

import duke.exceptions.DukeException;
import duke.exceptions.EmptyTaskException;
import duke.exceptions.IllegalDeadlineException;
import duke.exceptions.IllegalEventException;

import java.util.Scanner;

public class Duke {

    private static final String HORIZONTAL_LINE = "__________________________________________________";

    private static final String COMMAND_ADD_DEADLINE = "deadline";
    private static final String COMMAND_ADD_EVENT = "event";
    private static final String COMMAND_ADD_TODO = "todo";

    private static final String COMMAND_LIST = "list";
    private static final String COMMAND_MARK_DONE = "done";
    private static final String COMMAND_EXIT = "bye";

    private static final String PREFIX_BY_DEADLINE = "/by";
    private static final String PREFIX_TIME_EVENT = "/at";

    private static Ui ui = new Ui();
    private static ExceptionHandler exceptionHandler = new ExceptionHandler();

    private static final int MAX_NUMBER_OF_TASKS = 100;

    private static Task[] tasks = new Task[MAX_NUMBER_OF_TASKS];
    private static int numberOfTasks = 0;

    public static void main(String[] args) {
        ui.printGreeting();
        readAndExecuteCommand();
    }

    /**
     * Reads and executes command from user inputs.
     */
    private static void readAndExecuteCommand() {
        Scanner in = new Scanner(System.in);
        while (true) {
            String userInput = getUserInput(in);
            try {
                executeCommand(userInput);
            } catch (DukeException e) {
                exceptionHandler.handle(e);
            }
        }
    }

    /**
     * Reads the text entered by the user.
     *
     * @param in The Scanner to read user input.
     * @return line Full line entered by the user.
     */
    private static String getUserInput(Scanner in) {
        String line = in.nextLine();
        return line;
    }

    /**
     * Executes the command as specified by the user input.
     *
     * @param userInput Raw input from user.
     */
    private static void executeCommand(String userInput) throws DukeException {
        final String[] commandTypeAndParams = splitCommandAndArgs(userInput);
        final String commandType = commandTypeAndParams[0];
        final String commandArgs = commandTypeAndParams[1];

        switch (commandType) {
        case COMMAND_ADD_TODO:
            executeAddTodo(commandArgs);
            break;
        case COMMAND_ADD_DEADLINE:
            executeAddDeadline(commandArgs);
            break;
        case COMMAND_ADD_EVENT:
            executeAddEvent(commandArgs);
            break;
        case COMMAND_LIST:
            executeList();
            break;
        case COMMAND_MARK_DONE:
            executeMarkDone(commandArgs);
            break;
        case COMMAND_EXIT:
            executeExit();
            break;
        default:
            throw new DukeException();
        }
        System.out.println("\t" + HORIZONTAL_LINE);
    }

    /**
     * Executes exiting program.
     */
    private static void executeExit() {
        ui.printGoodBye();
        System.exit(0);
    }

    /**
     * Executes marking task as done.
     *
     * @param commandArgs Processed input arguments from user.
     */
    private static void executeMarkDone(String commandArgs) {
        int taskIndex = Integer.parseInt(commandArgs.strip()) - 1;
        Task currentTask = tasks[taskIndex];
        currentTask.markAsDone();
        ui.printConfirmMarkDone(currentTask);
    }

    /**
     * Executes listing tasks.
     */
    private static void executeList() {
        System.out.println("\t" + HORIZONTAL_LINE);
        if (numberOfTasks > 0) {
            System.out.println("\t" + "Here are the tasks in your list:");
            for (int i = 0; i < numberOfTasks; i++) {
                System.out.println("\t" + (i + 1) + ". " + tasks[i]);
            }
        } else {
            System.out.println("\t" + "You don't have any tasks. Add a ToDo, Deadline, or Event.");
        }
    }

    /**
     * Executes adding an event.
     *
     * @param commandArgs Processed input arguments from user.
     */
    private static void executeAddEvent(String commandArgs) throws IllegalEventException {
        int indexOfTimePrefix = commandArgs.indexOf(PREFIX_TIME_EVENT);
        if (indexOfTimePrefix != -1) {
            String description = commandArgs.substring(0, indexOfTimePrefix).trim();
            String time = commandArgs.substring(indexOfTimePrefix + 3).trim();
            tasks[numberOfTasks] = new Event(description, time);
            ui.printConfirmAdd(tasks[numberOfTasks], numberOfTasks);
            numberOfTasks++;
        } else {
            throw new IllegalEventException();
        }
    }

    /**
     * Executes adding a deadline.
     *
     * @param commandArgs Processed input arguments from user.
     */
    private static void executeAddDeadline(String commandArgs) throws IllegalDeadlineException {
        int indexOfByPrefix = commandArgs.indexOf(PREFIX_BY_DEADLINE);
        if (indexOfByPrefix != -1) {
            String description = commandArgs.substring(0, indexOfByPrefix).trim();
            String by = commandArgs.substring(indexOfByPrefix + 3).trim();
            tasks[numberOfTasks] = new Deadline(description, by);
            ui.printConfirmAdd(tasks[numberOfTasks], numberOfTasks);
            numberOfTasks++;
        } else {
            throw new IllegalDeadlineException();
        }
    }
    
    /**
     * Executes adding a todo.
     *
     * @param commandArgs Processed input arguments from user.
     */
    private static void executeAddTodo(String commandArgs) {
        String description = commandArgs.trim();
        tasks[numberOfTasks] = new ToDo(description);
        ui.printConfirmAdd(tasks[numberOfTasks], numberOfTasks);
        numberOfTasks++;
    }

    /**
     * Splits raw user input into command word and command arguments.
     *
     * @param userInput Raw input from user.
     * @return a String array of size 2 including the command type and the arguments.
     */
    private static String[] splitCommandAndArgs(String userInput) throws EmptyTaskException {
        final String[] tokens = userInput.trim().split("\\s+", 2);
        String command = tokens[0];
        boolean isCommandAdd = command.equals(COMMAND_ADD_DEADLINE) || command.equals(COMMAND_ADD_TODO)
                || command.equals(COMMAND_ADD_EVENT);

        if (tokens.length == 2) {
            return tokens;
        } else if (isCommandAdd) {
            throw new EmptyTaskException();
        } else {
            return new String[] {command, ""};
        }
    }

}
