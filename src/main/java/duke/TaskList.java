package duke;

import duke.task.Task;

import java.util.ArrayList;

/**
 * A class represents a list of tasks.
 */
public class TaskList {

    protected ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public ArrayList<Task> getTasksList() {
        return tasks;
    }

    public int getNumberOfTasks() {
        return tasks.size();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public Task getTaskByIndex(int index) {
        return tasks.get(index);
    }

    public void removeTaskByIndex(int index) {
        tasks.remove(index);
    }
    
}
