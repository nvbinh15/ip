package duke;

import duke.exceptions.EmptyTaskException;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import static duke.constants.CommandConstants.COMMAND_ADD_DEADLINE;
import static duke.constants.CommandConstants.COMMAND_ADD_TODO;
import static duke.constants.CommandConstants.COMMAND_ADD_EVENT;

import static duke.constants.Messages.LINE_SEPARATOR;
import static duke.constants.Messages.VERTICAL_BAR;
import static duke.constants.Messages.VERTICAL_BAR_REGEX;
import static duke.constants.Messages.EMPTY_STRING;

import static duke.constants.TaskConstants.PREFIX_EVENT;
import static duke.constants.TaskConstants.PREFIX_DEADLINE;
import static duke.constants.TaskConstants.PREFIX_TODO;
import static duke.constants.TaskConstants.STATUS_ICON_DONE;

public class Parser {

    public Parser() {

    }

    public static String formatTaskToStore(Task task) {
        String prefix;
        String by;
        String time;
        String data;
        String description = task.getDescription();
        String statusIcon = task.getStatusIcon();
        if (task instanceof Deadline) {
            prefix = PREFIX_DEADLINE;
            by = ((Deadline) task).getBy();
            data = prefix + VERTICAL_BAR + statusIcon + VERTICAL_BAR + description + VERTICAL_BAR + by + LINE_SEPARATOR;
        } else if (task instanceof Event) {
            prefix = PREFIX_EVENT;
            time = ((Event) task).getTime();
            data = prefix + VERTICAL_BAR + statusIcon + VERTICAL_BAR + description + VERTICAL_BAR + time + LINE_SEPARATOR;
        } else {
            prefix = PREFIX_TODO;
            data = prefix + VERTICAL_BAR + statusIcon + VERTICAL_BAR + description + LINE_SEPARATOR;
        }
        return data;
    }

    public static Task retrieveStoredData(String data) {
        String[] tokens = data.split(VERTICAL_BAR_REGEX);
        String prefix = tokens[0];
        String statusIcon = tokens[1];
        String description = tokens[2];
        boolean isDone = (statusIcon.equals(STATUS_ICON_DONE)) ? true : false;

        if (prefix == PREFIX_EVENT) {
            String time = tokens[3];
            return new Event(description, isDone, time);
        } else if (prefix == PREFIX_DEADLINE) {
            String by = tokens[3];
            return new Deadline(description, isDone, by);
        } else {
            return new ToDo(description, isDone);
        }
    }

    /**
     * Splits raw user input into command word and command arguments.
     *
     * @param userInput Raw input from user.
     * @return a String array of size 2 including the command type and the arguments.
     */
    public static String[] splitCommandAndArgs(String userInput) throws EmptyTaskException {
        String[] tokens = userInput.trim().split("\\s+", 2);
        String command = tokens[0];
        boolean isCommandAdd = command.equals(COMMAND_ADD_DEADLINE) || command.equals(COMMAND_ADD_TODO)
                || command.equals(COMMAND_ADD_EVENT);

        if (tokens.length == 2) {
            return tokens;
        } else if (isCommandAdd) {
            throw new EmptyTaskException();
        } else {
            return new String[] {command, EMPTY_STRING};
        }
    }

}
