package duke.commands;

import duke.components.Storage;
import duke.components.TaskList;
import duke.components.Ui;
import duke.exceptions.IllegalDeadlineException;
import duke.task.Deadline;

import java.io.IOException;

import static duke.constants.TaskConstants.PREFIX_BY_DEADLINE;

public class AddDeadlineCommand extends Command {

    String commandArgs;

    /**
     * Class constructor specifying the command arguments.
     *
     * @param commandArgs The command arguments.
     */
    public AddDeadlineCommand(String commandArgs) {
        this.commandArgs = commandArgs;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws IllegalDeadlineException, IOException {
        int indexOfByPrefix = commandArgs.indexOf(PREFIX_BY_DEADLINE);
        if (indexOfByPrefix == -1) {
            throw new IllegalDeadlineException();
        }
        String description = commandArgs.substring(0, indexOfByPrefix).trim();
        String by = commandArgs.substring(indexOfByPrefix + 3).trim();
        Deadline toBeAddedDeadline = new Deadline(description, by);
        tasks.addTask(toBeAddedDeadline);
        ui.printConfirmAdd(toBeAddedDeadline, tasks.getNumberOfTasks());
        storage.saveDataToFile(tasks);
    }
}
