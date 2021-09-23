package duke.commands;

import duke.components.Storage;
import duke.components.TaskList;
import duke.components.Ui;

/**
 * A representation of the command for exiting the program.
 */
public class ExitCommand extends Command {

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.printGoodBye();
        System.exit(0);
    }
}
