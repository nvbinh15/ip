package duke.task;

import static duke.constants.Messages.OPEN_SQUARE_BRACKET;
import static duke.constants.Messages.CLOSE_SQUARE_BRACKET;

import static duke.constants.TaskConstants.PREFIX_EVENT;

public class Event extends Task {

    protected String time;

    public Event(String description, String time) {
        super(description);
        this.time = time;
    }

    public Event(String description, boolean isDone, String time) {
        super(description, isDone);
        this.time = time;
    }

    public String getTime() {
        return this.time;
    }

    @Override
    public String toString() {
        return OPEN_SQUARE_BRACKET + PREFIX_EVENT + CLOSE_SQUARE_BRACKET + super.toString() + " (at: " + this.time + ")";
    }
}
