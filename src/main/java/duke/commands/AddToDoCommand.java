package duke.commands;

import duke.components.Storage;
import duke.components.TaskList;
import duke.components.Ui;
import duke.task.ToDo;

import java.io.IOException;

/**
 * A representation of the command for adding a ToDo.
 */
public class AddToDoCommand extends Command {

    String commandArgs;

    /**
     * Class constructor specifying the command arguments.
     *
     * @param commandArgs The command arguments.
     */
    public AddToDoCommand (String commandArgs) {
        this.commandArgs = commandArgs;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws IOException {
        String description = commandArgs.trim();
        tasks.addTask(new ToDo(description));
        ui.printConfirmAdd(tasks.getTaskByIndex(tasks.getNumberOfTasks() - 1), tasks.getNumberOfTasks());
        storage.saveDataToFile(tasks);
    }

}
