import java.util.Locale;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        final String HORIZONTAL_LINE = "__________________________________________________";
        System.out.println("\t" + HORIZONTAL_LINE);
        System.out.println("\t" + "Hello! I'm Duke");
        System.out.println("\t" + "What can I do for you?");
        System.out.println("\t" + HORIZONTAL_LINE);

        Task[] tasks = new Task[100];
        int numberOfTasks = 0;

        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        while (!line.equals("bye")) {
            System.out.println("\t" + HORIZONTAL_LINE);
            if (line.equals("list")) {
                System.out.println("\t" + "Here are the tasks in your list:");
                for (int i = 0; i < numberOfTasks; i++) {
                    System.out.println("\t" + (i + 1) + ". "
                            + "[" +tasks[i].getStatusIcon() + "] " + tasks[i].description);
                }
            } else if (line.startsWith("done")) {
                System.out.println("\t" + "Nice! I've marked this task as done:");
                Task currentTask = tasks[Integer.parseInt(line.substring(5)) - 1];
                currentTask.markAsDone();
                System.out.println("\t" + "\t" + "[" + currentTask.getStatusIcon() + "] " + currentTask.description);
            } else {
                tasks[numberOfTasks] = new Task(line);
                numberOfTasks++;
                System.out.println("\t" + "added: " + line);
            }
            System.out.println("\t" + HORIZONTAL_LINE);
            line = in.nextLine();
        }

        System.out.println("\t" + HORIZONTAL_LINE);
        System.out.println("\t" + "Bye. Hope to see you again soon!");
        System.out.println("\t" + HORIZONTAL_LINE);
    }
}
