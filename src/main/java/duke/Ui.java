package duke;

import duke.task.Task;

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
        System.out.println("\t" + HORIZONTAL_LINE);
        System.out.println("\t" + "Bye. Hope to see you again soon!");
        System.out.println("\t" + HORIZONTAL_LINE);
    }

    /**
     * Prints confirm message after adding ToDo, Event, or Deadline.
     */
    public static void printConfirmAdd(Task task, int numberOfTasks) {
        System.out.println("\t" + HORIZONTAL_LINE);
        System.out.println("\t" + "Got it. I've added this task:");
        System.out.println("\t" + "\t" + task);
        if (numberOfTasks == 0) {
            System.out.println("\t" + "Now you have one task in the list.");
        } else {
            System.out.println("\t" + "Now you have " + (numberOfTasks + 1) + " tasks in the list.");
        }
    }

    /**
     * Prints confirm message after marking a task as done.
     *
     * @param task The task to be marked as done.
     */
    public static void printConfirmMarkDone(Task task) {
        System.out.println("\t" + HORIZONTAL_LINE);
        System.out.println("\t" + "Nice! I've marked this task as done:");
        System.out.println("\t" + "\t" + task);
    }

    /**
     * Prints exception message.
     *
     * @param message The exception message.
     */
    public static void printException(String message) {
        System.out.println("\t" + HORIZONTAL_LINE);
        System.out.println(message);
        System.out.println("\t" + HORIZONTAL_LINE);
    }
}
