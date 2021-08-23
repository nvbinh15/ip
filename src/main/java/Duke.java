import java.util.Locale;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        final String HORIZONTAL_LINE = "__________________________________________________";
        System.out.println("\t" + HORIZONTAL_LINE);
        System.out.println("\t" + "Hello! I'm Duke");
        System.out.println("\t" + "What can I do for you?");
        System.out.println("\t" + HORIZONTAL_LINE);

        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        while (!line.equals("bye")) {
            System.out.println("\t" + HORIZONTAL_LINE);
            System.out.println("\t" + line);
            System.out.println("\t" + HORIZONTAL_LINE);
            line = in.nextLine();
        }

        System.out.println("\t" + HORIZONTAL_LINE);
        System.out.println("\t" + "Bye. Hope to see you again soon!");
        System.out.println("\t" + HORIZONTAL_LINE);
    }
}
