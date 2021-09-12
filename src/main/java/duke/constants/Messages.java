package duke.constants;

public class Messages {

    public final static String LOGO = "\t" + " ____        _\n"
            + "\t" + "|  _ \\ _   _| | _____\n"
            + "\t" + "| | | | | | | |/ / _ \\\n"
            + "\t" + "| |_| | |_| |   <  __/\n"
            + "\t" + "|____/ \\__,_|_|\\_\\___|\n\n";

    public static final String OPEN_SQUARE_BRACKET = "[";
    public static final String CLOSE_SQUARE_BRACKET = "]";
    public static final String VERTICAL_BAR = " | ";
    public static final String VERTICAL_BAR_REGEX = " \\| ";
    public static final String EMPTY_STRING = "";

    public static final String LINE_PREFIX = "\t";
    public static final String LINE_SEPARATOR = System.lineSeparator();
    public static final String NEW_LINE = LINE_SEPARATOR + LINE_PREFIX;
    public static final String HORIZONTAL_LINE = LINE_PREFIX + "__________________________________________________";

    public static final String MESSAGE_GREETING = LINE_PREFIX + "Hello! I'm Duke" + NEW_LINE + "What can I do for you?";
    public static final String MESSAGE_GOODBYE = LINE_PREFIX + "Bye. Hope to see you again soon!";

    public static final String MESSAGE_NO_TASK = LINE_PREFIX + "You don't have any tasks. Add a ToDo, Deadline, or Event.";
    public static final String MESSAGE_MARK_TASK_DONE = LINE_PREFIX + "Nice! I've marked this task as done:";

    public static final String MESSAGE_DUKE_EXCEPTION = LINE_PREFIX + "OOPS!!! I'm sorry, but I don't know what that means :-(.";
    public static final String MESSAGE_EMPTY_TASK_EXCEPTION = LINE_PREFIX + "OOPS!!! The description of a task cannot be empty.";
    public static final String MESSAGE_INVALID_DEADLINE_EXCEPTION = LINE_PREFIX + "OOPS!!! Invalid deadline.";
    public static final String MESSAGE_INVALID_EVENT_EXCEPTION = LINE_PREFIX + "OOPS!!! Invalid event.";
    public static final String MESSAGE_OTHER_EXCEPTION = LINE_PREFIX + "Something went wrong. Please try again!";
    public static final String MESSAGE_FILE_NOT_FOUND = LINE_PREFIX + "File not found.";
}
