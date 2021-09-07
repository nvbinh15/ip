package duke;

public class ExceptionHandler {

    private static Ui ui = new Ui();

    private static final String EXCEPTION_DUKE_MESSAGE = "\t" + "OOPS!!! I'm sorry, but I don't know what that means :-(.";
    private static final String EXCEPTION_EMPTY_TASK_MESSAGE = "\t" + "OOPS!!! The description of a task cannot be empty.";
    private static final String EXCEPTION_DEADLINE_MESSAGE = "\t" + "OOPS!!! Invalid deadline.";
    private static final String EXCEPTION_EVENT_MESSAGE = "\t" + "OOPS!!! Invalid event.";

    /**
     * Handles exceptions.
     *
     * @param e Exception thrown by Duke.
     */
    public static void handle(DukeException e) {
        if (e instanceof IllegalDeadlineException) {
            ui.printException(EXCEPTION_DEADLINE_MESSAGE);
        } else if (e instanceof IllegalEventException) {
            ui.printException(EXCEPTION_EVENT_MESSAGE);
        } else if (e instanceof EmptyTaskException) {
            ui.printException(EXCEPTION_EMPTY_TASK_MESSAGE);
        } else {
            ui.printException(EXCEPTION_DUKE_MESSAGE);
        }
    }
}
