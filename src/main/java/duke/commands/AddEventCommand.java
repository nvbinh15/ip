package duke.commands;

import duke.components.Storage;
import duke.components.TaskList;
import duke.components.Ui;
import duke.exceptions.IllegalEventException;
import duke.task.Event;

import java.io.IOException;

import static duke.constants.TaskConstants.PREFIX_TIME_EVENT;

public class AddEventCommand extends Command {

    String commandArgs;

    /**
     * Class constructor specifying the command arguments.
     *
     * @param commandArgs The command arguments.
     */
    public AddEventCommand(String commandArgs) {
        this.commandArgs = commandArgs;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws IllegalEventException, IOException {
        int indexOfTimePrefix = commandArgs.indexOf(PREFIX_TIME_EVENT);
        if (indexOfTimePrefix == -1) {
            throw new IllegalEventException();
        }
        String description = commandArgs.substring(0, indexOfTimePrefix).trim();
        String time = commandArgs.substring(indexOfTimePrefix + 3).trim();
        Event toBeAddedEvent = new Event(description, time);
        tasks.addTask(toBeAddedEvent);
        ui.printConfirmAdd(toBeAddedEvent, tasks.getNumberOfTasks());
        storage.saveDataToFile(tasks);
    }
}
