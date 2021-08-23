import java.util.Locale;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        final String HORIZONTAL_LINE = "__________________________________________________";
        System.out.println("\t" + HORIZONTAL_LINE);
        System.out.println("\t" + "Hello! I'm Duke");
        System.out.println("\t" + "What can I do for you?");
        System.out.println("\t" + HORIZONTAL_LINE);

        String[] tasks = new String[100];
        int numberOfTasks = 0;

        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        while (!line.equals("bye")) {
            System.out.println("\t" + HORIZONTAL_LINE);
            if (line.equals("list")) {
                for (int i = 0; i < numberOfTasks; i++) {
                    System.out.println("\t" + (i + 1) + ". " + tasks[i]);
                }
            } else {
                tasks[numberOfTasks] = line;
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
