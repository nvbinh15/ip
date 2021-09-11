package duke;

import duke.task.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;

import static duke.constants.StorageConfig.PATH_TO_STORAGE_FILE;

public class Storage {

    static Parser parser = new Parser();

    private static void createFile() throws IOException {
        File file = new File(String.valueOf(PATH_TO_STORAGE_FILE));
        file.getParentFile().mkdirs();
        file.createNewFile();
    }

    public static ArrayList<Task> readDataFromFile() throws IOException {
        if (Files.notExists(PATH_TO_STORAGE_FILE)) {
            createFile();
        }
        ArrayList<Task> storedTasks = new ArrayList<>();
        File file = new File(String.valueOf(PATH_TO_STORAGE_FILE));
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                Task task = parser.retrieveStoredData(scanner.nextLine());
                storedTasks.add(task);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        return storedTasks;
    }

    public static void saveDataToFile(TaskList tasksList) throws IOException {
        FileWriter fileWriter = new FileWriter(String.valueOf(PATH_TO_STORAGE_FILE));
        for (Task t : tasksList.tasks) {
            fileWriter.write(parser.formatTaskToStore(t));
        }
        fileWriter.close();
    }
}
