package duke.commands;

import duke.components.Storage;
import duke.components.TaskList;
import duke.components.Ui;
import duke.task.Task;

import static duke.constants.Messages.HORIZONTAL_LINE;
import static duke.constants.Messages.LINE_PREFIX;

/**
 * A representation of the command for finding a task.
 */
public class FindCommand extends Command {

    String keyword;

    /**
     * Class constructor specifying the keyword.
     *
     * @param keyword The keyword that is used to find relevant tasks.
     */
    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        System.out.println(HORIZONTAL_LINE);
        int numberOfMatches = 0;
        boolean hasMatch = false;
        for (int i = 0; i < tasks.getNumberOfTasks(); i++) {
            Task task = tasks.getTaskByIndex(i);
            if (task.getDescription().contains(this.keyword)) {
                if (!hasMatch) {
                    System.out.println(LINE_PREFIX + "Here are the matching tasks in your list:");
                    hasMatch = true;
                }
                numberOfMatches++;
                System.out.println("\t" + numberOfMatches + ". " + task);
            }
        }

        if (!hasMatch) {
            System.out.println(LINE_PREFIX + "There is no task in your list.");
        }
    }
}
