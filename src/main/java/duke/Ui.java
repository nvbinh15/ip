package duke;

import duke.task.Task;

import static duke.constants.Messages.HORIZONTAL_LINE;
import static duke.constants.Messages.LOGO;
import static duke.constants.Messages.MESSAGE_GREETING;
import static duke.constants.Messages.MESSAGE_GOODBYE;
import static duke.constants.Messages.MESSAGE_MARK_TASK_DONE;
import static duke.constants.Messages.LINE_PREFIX;

public class Ui {

    /**
     * Prints the greeting message to standard output.
     */
    public static void printGreeting() {
        printMessage(LOGO + MESSAGE_GREETING);
    }

    /**
     * Prints the goodbye message to standard output.
     */
    public static void printGoodBye() {
        printMessage(MESSAGE_GOODBYE);
    }

    /**
     * Prints confirm message after adding ToDo, Event, or Deadline.
     */
    public static void printConfirmAdd(Task task, int numberOfTasks) {
        System.out.println(HORIZONTAL_LINE);
        System.out.println(LINE_PREFIX + "Got it. I've added this task:");
        System.out.println(LINE_PREFIX + LINE_PREFIX + task);
        if (numberOfTasks == 1) {
            System.out.println(LINE_PREFIX + "Now you have one task in the list.");
        } else {
            System.out.println(LINE_PREFIX + "Now you have " + numberOfTasks + " tasks in the list.");
        }
    }

    public static void printConfirmDelete(Task task, int numberOfTasksBeforeDelete) {
        System.out.println(HORIZONTAL_LINE);
        System.out.println(LINE_PREFIX + "Noted. I've removed this task:");
        System.out.println(LINE_PREFIX + LINE_PREFIX + task);
        if (numberOfTasksBeforeDelete == 2) {
            System.out.println(LINE_PREFIX + "Now you have one task in the list.");
        } else if (numberOfTasksBeforeDelete == 1) {
            System.out.println(LINE_PREFIX + "Now you have zero task in the list.");
        } else {
            System.out.println(LINE_PREFIX + "Now you have " + (numberOfTasksBeforeDelete - 1) + " tasks in the list.");
        }
    }

    /**
     * Prints confirm message after marking a task as done.
     *
     * @param task The task to be marked as done.
     */
    public static void printConfirmMarkDone(Task task) {
        System.out.println(HORIZONTAL_LINE);
        System.out.println(MESSAGE_MARK_TASK_DONE);
        System.out.println(LINE_PREFIX + LINE_PREFIX + task);
    }

    /**
     * Prints message to the standard output.
     *
     * @param message The message to be printed.
     */
    public static void printMessage(String message) {
        System.out.println(HORIZONTAL_LINE);
        System.out.println(message);
        System.out.println(HORIZONTAL_LINE);
    }
}
