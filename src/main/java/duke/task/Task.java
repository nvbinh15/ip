package duke.task;

import static duke.constants.Messages.OPEN_SQUARE_BRACKET;
import static duke.constants.Messages.CLOSE_SQUARE_BRACKET;

import static duke.constants.TaskConstants.STATUS_ICON_DONE;
import static duke.constants.TaskConstants.STATUS_ICON_UNDONE;

public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Class constructor specifying the description of the task.
     *
     * @param description Description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    /**
     * Returns the "X" or " " icon based on whether the task is done.
     *
     * @return the corresponding icon.
     */
    public String getStatusIcon() {
        return (isDone ? STATUS_ICON_DONE : STATUS_ICON_UNDONE);
    }

    /**
     * Marks the task as done.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean getIsDone() {
        return this.isDone;
    }

    @Override
    public String toString() {
        return OPEN_SQUARE_BRACKET + this.getStatusIcon() + CLOSE_SQUARE_BRACKET + " " + this.description;
    }
}
