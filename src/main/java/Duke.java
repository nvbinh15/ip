import java.util.Scanner;

public class Duke {

    private static final String HORIZONTAL_LINE = "__________________________________________________";

    private static final String PREFIX_BY_DEADLINE = "/by";
    private static final String PREFIX_TIME_EVENT = "/at";

    private static final String COMMAND_ADD_DEADLINE = "deadline";
    private static final String COMMAND_ADD_EVENT = "event";
    private static final String COMMAND_ADD_TODO = "todo";

    private static final String COMMAND_LIST = "list";
    private static final String COMMAND_MARK_DONE = "done";
    private static final String COMMAND_EXIT = "bye";

    private static final int MAX_NUMBER_OF_TASKS = 100;

    private static Task[] tasks = new Task[MAX_NUMBER_OF_TASKS];
    private static int numberOfTasks = 0;

    public static void main(String[] args) {
        printGreeting();
        while (true) {
            String userInput = getUserInput();
            executeCommand(userInput);
        }
    }

    /**
     * Reads the text entered by the user.
     *
     * @return line Full line entered by the user.
     */
    private static String getUserInput() {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        return line;
    }

    /**
     * Executes the command as specified by the user command.
     *
     * @param userInput Raw input from user.
     */
    private static void executeCommand(String userInput) {
        final String[] commandTypeAndParams = splitCommandAndArgs(userInput);
        final String commandType = commandTypeAndParams[0];
        final String commandArgs = commandTypeAndParams[1];

        System.out.println("\t" + HORIZONTAL_LINE);

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
            System.out.println("\t" + "Unknown command. Please try another.");
        }
        System.out.println("\t" + HORIZONTAL_LINE);
    }

    /**
     * Executes exiting program.
     */
    private static void executeExit() {
        printGoodBye();
        System.exit(0);
    }

    /**
     * Executes marking task as done.
     *
     * @param commandArgs Processed input arguments from user.
     */
    private static void executeMarkDone(String commandArgs) {
        System.out.println("\t" + "Nice! I've marked this task as done:");
        int taskIndex = Integer.parseInt(commandArgs.strip()) - 1;
        Task currentTask = tasks[taskIndex];
        currentTask.markAsDone();
        System.out.println("\t" + "\t" + currentTask);
    }

    /**
     * Executes listing tasks.
     */
    private static void executeList() {
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
    private static void executeAddEvent(String commandArgs) {
        int indexOfTimePrefix = commandArgs.indexOf(PREFIX_TIME_EVENT);
        String description = commandArgs.substring(0, indexOfTimePrefix).trim();
        String time = commandArgs.substring(indexOfTimePrefix + 3).trim();
        tasks[numberOfTasks] = new Event(description, time);
        printConfirmAdd();
    }

    /**
     * Executes adding a deadline.
     *
     * @param commandArgs Processed input arguments from user.
     */
    private static void executeAddDeadline(String commandArgs) {
        int indexOfByPrefix = commandArgs.indexOf(PREFIX_BY_DEADLINE);
        String description = commandArgs.substring(0, indexOfByPrefix).trim();
        String by = commandArgs.substring(indexOfByPrefix + 3).trim();
        tasks[numberOfTasks] = new Deadline(description, by);
        printConfirmAdd();
    }

    /**
     * Prints confirm message after adding ToDo, Event, or Deadline.
     */
    private static void printConfirmAdd() {
        System.out.println("\t" + "Got it. I've added this task: ");
        System.out.println("\t" + "\t" + tasks[numberOfTasks]);
        numberOfTasks++;
        if (numberOfTasks == 1) {
            System.out.println("\t" + "Now you have one task in the list.");
        } else {
            System.out.println("\t" + "Now you have " + numberOfTasks + " tasks in the list.");
        }
    }

    /**
     * Executes adding a todo
     *
     * @param commandArgs Processed input arguments from user.
     */
    private static void executeAddTodo(String commandArgs) {
        tasks[numberOfTasks] = new ToDo(commandArgs);
        printConfirmAdd();
    }

    /**
     * Splits raw user input into command word and command arguments.
     *
     * @param userInput Raw input from user.
     * @return a String array of size 2 including the command type and the arguments.
     */
    private static String[] splitCommandAndArgs(String userInput) {
        final String[] tokens = userInput.trim().split("\\s+", 2);
        if (tokens.length == 2) {
            return tokens;
        } else {
            return new String[] {tokens[0], ""};
        }
    }

    /**
     * Prints the greeting message to standard output.
     */
    private static void printGreeting() {
        System.out.println("\t" + HORIZONTAL_LINE);
        System.out.println("\t" + "Hello! I'm Duke");
        System.out.println("\t" + "What can I do for you?");
        System.out.println("\t" + HORIZONTAL_LINE);
    }

    /**
     * Prints the goodbye message to standard output.
     */
    private static void printGoodBye() {
        System.out.println("\t" + "Bye. Hope to see you again soon!");
        System.out.println("\t" + HORIZONTAL_LINE);
    }
}
