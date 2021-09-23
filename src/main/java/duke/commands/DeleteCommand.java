package duke.commands;

import duke.components.Storage;
import duke.components.TaskList;
import duke.components.Ui;

import java.io.IOException;

/**
 * A representation of the command for deleting a task.
 */
public class DeleteCommand extends Command {

    String commandArgs;

    /**
     * Class constructor specifying the command arguments.
     *
     * @param commandArgs The command arguments.
     */
    public DeleteCommand(String commandArgs) {
        this.commandArgs = commandArgs;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws IOException {
        int taskIndex = Integer.parseInt(commandArgs.strip()) - 1;
        ui.printConfirmDelete(tasks.getTaskByIndex(taskIndex), tasks.getNumberOfTasks());
        tasks.removeTaskByIndex(taskIndex);
        storage.saveDataToFile(tasks);
    }
}
