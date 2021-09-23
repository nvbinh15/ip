package duke.components;

import duke.commands.*;
import duke.exceptions.DukeException;
import duke.exceptions.EmptyTaskException;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static duke.constants.CommandConstants.*;
import static duke.constants.CommandConstants.COMMAND_EXIT;

import static duke.constants.Messages.*;
import static duke.constants.TaskConstants.PREFIX_EVENT;
import static duke.constants.TaskConstants.PREFIX_DEADLINE;
import static duke.constants.TaskConstants.PREFIX_TODO;
import static duke.constants.TaskConstants.STATUS_ICON_DONE;

/**
 * A class that deals with making sense of the user command
 * and formatting data to stored and retrieved from the storage.
 */
public class Parser {

    /**
     * Class constructor.
     */
    public Parser() {

    }

    /**
     * Formats a task to be stored in the storage file.
     *
     * @param task The task to be formatted.
     * @return The formatted string representation of task.
     */
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

    /**
     * Retrieves a task from the storage file.
     *
     * @param data The string representation of the task in the storage file.
     * @return The task to be retrieved.
     */
    public static Task retrieveStoredData(String data) {
        String[] tokens = data.split(VERTICAL_BAR_REGEX);
        String prefix = tokens[0];
        String statusIcon = tokens[1];
        String description = tokens[2];
        boolean isDone = (statusIcon.equals(STATUS_ICON_DONE)) ? true : false;

        switch (prefix) {
        case PREFIX_EVENT:
            String time = tokens[3];
            return new Event(description, isDone, time);
        case PREFIX_DEADLINE:
            String by = tokens[3];
            return new Deadline(description, isDone, by);
        default:
            return new ToDo(description, isDone);
        }
    }

    /**
     * Splits raw user input into command word and command arguments.
     *
     * @param userInput Raw input from user.
     * @return a String array of size 2 including the command type and the arguments.
     * @throws EmptyTaskException If the add task command has no task description.
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

    public static LocalDateTime stringToDateTime(String string) {
        return LocalDateTime.parse(string, DateTimeFormatter.ofPattern("dd-MM-yyyy HHmm"));
    }

    public static String dateTimeToString(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm"));
    }

    public static String formatDateTime(String rawDateTime) {
        return dateTimeToString(stringToDateTime(rawDateTime));
    }

    /**
     * Returns a to be executed command based on the raw input from user.
     *
     * @param userInput The raw input from user.
     * @return The command to be executed.
     * @throws DukeException If there is an exception of type DukeException occurs.
     */
    public Command parseCommand(String userInput) throws DukeException {
        final String[] commandTypeAndParams = splitCommandAndArgs(userInput);
        final String commandType = commandTypeAndParams[0];
        final String commandArgs = commandTypeAndParams[1];

        switch (commandType) {
        case COMMAND_ADD_TODO:
            return new AddToDoCommand(commandArgs);
        case COMMAND_ADD_DEADLINE:
            return new AddDeadlineCommand(commandArgs);
        case COMMAND_ADD_EVENT:
            return new AddEventCommand(commandArgs);
        case COMMAND_LIST:
            return new ListCommand();
        case COMMAND_MARK_DONE:
            return new MarkDoneCommand(commandArgs);
        case COMMAND_DELETE:
            return new DeleteCommand(commandArgs);
        case COMMAND_EXIT:
            return new ExitCommand();
        default:
            throw new DukeException();
        }
    }

}
