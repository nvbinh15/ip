package duke;

import java.io.IOException;

import duke.exceptions.DukeException;
import duke.exceptions.IllegalDeadlineException;
import duke.exceptions.IllegalEventException;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import static duke.constants.CommandConstants.COMMAND_ADD_TODO;
import static duke.constants.CommandConstants.COMMAND_ADD_EVENT;
import static duke.constants.CommandConstants.COMMAND_ADD_DEADLINE;
import static duke.constants.CommandConstants.COMMAND_MARK_DONE;
import static duke.constants.CommandConstants.COMMAND_LIST;
import static duke.constants.CommandConstants.COMMAND_EXIT;

import static duke.constants.TaskConstants.PREFIX_BY_DEADLINE;
import static duke.constants.TaskConstants.PREFIX_TIME_EVENT;
import static duke.constants.Messages.HORIZONTAL_LINE;

import static duke.constants.Messages.MESSAGE_NO_TASK;

import java.util.Scanner;

public class Duke {

    private static Ui ui = new Ui();
    private static ExceptionHandler exceptionHandler = new ExceptionHandler();
    private static Storage storage = new Storage();
    private static Parser parser = new Parser();

    private static TaskList tasks = new TaskList();

    public static void main(String[] args) throws IOException {
        ui.printGreeting();
        readAndExecuteCommand();
    }

    /**
     * Reads and executes command from user inputs.
     */
    private static void readAndExecuteCommand() throws IOException {
        Scanner in = new Scanner(System.in);
        tasks.tasks = storage.readDataFromFile();
        while (true) {
            String userInput = getUserInput(in);
            try {
                executeCommand(userInput);
            } catch (DukeException e) {
                exceptionHandler.handleDukeExceptions(e);
            } catch (Exception e) {
                exceptionHandler.handleOtherExceptions(e);
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
    private static void executeCommand(String userInput) throws DukeException, IOException {
        final String[] commandTypeAndParams = parser.splitCommandAndArgs(userInput);
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
        System.out.println(HORIZONTAL_LINE);
    }

    /**
     * Executes exiting program.
     */
    private static void executeExit() throws IOException {
        storage.saveDataToFile(tasks);
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
        Task currentTask = tasks.getTaskByIndex(taskIndex);
        currentTask.markAsDone();
        ui.printConfirmMarkDone(currentTask);
    }

    /**
     * Executes listing tasks.
     */
    private static void executeList() {
        System.out.println(HORIZONTAL_LINE);
        if (tasks.getNumberOfTasks() > 0) {
            System.out.println("\t" + "Here are the tasks in your list:");
            for (int i = 0; i < tasks.getNumberOfTasks(); i++) {
                System.out.println("\t" + (i + 1) + ". " + tasks.getTaskByIndex(i));
            }
        } else {
            System.out.println(MESSAGE_NO_TASK);
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
            tasks.addTask(new Event(description, time));
            ui.printConfirmAdd(tasks.getTaskByIndex(tasks.getNumberOfTasks() - 1), tasks.getNumberOfTasks());
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
            tasks.addTask(new Deadline(description, by));
            ui.printConfirmAdd(tasks.getTaskByIndex(tasks.getNumberOfTasks() - 1), tasks.getNumberOfTasks());
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
        tasks.addTask(new ToDo(description));
        ui.printConfirmAdd(tasks.getTaskByIndex(tasks.getNumberOfTasks() - 1), tasks.getNumberOfTasks());
    }

}
