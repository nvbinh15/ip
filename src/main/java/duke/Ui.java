package duke;

public class Ui {

    private final static String LOGO = "\t" + " ____        _\n"
            + "\t" + "|  _ \\ _   _| | _____\n"
            + "\t" + "| | | | | | | |/ / _ \\\n"
            + "\t" + "| |_| | |_| |   <  __/\n"
            + "\t" + "|____/ \\__,_|_|\\_\\___|\n";

    private static final String HORIZONTAL_LINE = "__________________________________________________";

    /**
     * Prints the greeting message to standard output.
     */
    public static void printGreeting() {
        System.out.println("\t" + HORIZONTAL_LINE);
        System.out.println(LOGO);
        System.out.println("\t" + "Hello! I'm Duke");
        System.out.println("\t" + "What can I do for you?");
        System.out.println("\t" + HORIZONTAL_LINE);
    }

    /**
     * Prints the goodbye message to standard output.
     */
    public static void printGoodBye() {
        System.out.println("\t" + "Bye. Hope to see you again soon!");
        System.out.println("\t" + HORIZONTAL_LINE);
    }

    /**
     * Prints confirm message after adding ToDo, Event, or Deadline.
     */
    public static void printConfirmAdd(Task task, int numberOfTasks) {
        System.out.println("\t" + "Got it. I've added this task:");
        System.out.println("\t" + "\t" + task);
        if (numberOfTasks == 0) {
            System.out.println("\t" + "Now you have one task in the list.");
        } else {
            System.out.println("\t" + "Now you have " + (numberOfTasks + 1) + " tasks in the list.");
        }
    }

    /**
     * Prints the result message to standard output after executing commands.
     *
     * @param message Message to show to the user
     */
    public static void printMessage(String message) {
        System.out.println(message);
    }
}
