package duke.task;

import static duke.constants.Messages.OPEN_SQUARE_BRACKET;
import static duke.constants.Messages.CLOSE_SQUARE_BRACKET;

import static duke.constants.TaskConstants.PREFIX_TODO;

public class ToDo extends Task {

    public ToDo (String description) {
        super(description);
    }

    public ToDo (String description, boolean isDone) {
        super(description, isDone);
    }

    @Override
    public String toString() {
        return OPEN_SQUARE_BRACKET + PREFIX_TODO + CLOSE_SQUARE_BRACKET + super.toString();
    }
}
