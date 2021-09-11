package duke.task;

import static duke.constants.Messages.OPEN_SQUARE_BRACKET;
import static duke.constants.Messages.CLOSE_SQUARE_BRACKET;

import static duke.constants.TaskConstants.PREFIX_DEADLINE;

public class Deadline extends Task {

    protected String by;

    public Deadline (String description, String by) {
        super(description);
        this.by = by;
    }

    public Deadline (String description, boolean isDone, String by) {
        super(description, isDone);
        this.by = by;
    }

    public String getBy() {
        return this.by;
    }

    @Override
    public String toString() {
        return OPEN_SQUARE_BRACKET + PREFIX_DEADLINE + CLOSE_SQUARE_BRACKET + super.toString() + " (by: " + by + ")";
    }
}
