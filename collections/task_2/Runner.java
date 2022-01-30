package collections.task_2;

import util.display.PageViewer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Enter lines from the file, write to the list.
 * Write the lines to the file in reverse order.
 */

public class Runner {
    private static final Path FILE_PATH =
            Paths.get("src/main/java/collections/task_2/resources/texts/RandomText.txt");
    private static final Path REVERSED_FILE_PATH =
            Paths.get("src/main/java/collections/task_2/resources/reversed_texts/ReversedRandomText.txt");

    public static void main(String[] args) {
        System.out.println(FILE_PATH.getFileName() + " lines:");
        List<String> fileLines = getFileLines();
        PageViewer.pageDisplay(fileLines);
        System.out.println("\n" + REVERSED_FILE_PATH.getFileName() + " lines:");
        List<String> reversedLines = writeAndGetReversed(fileLines);
        PageViewer.pageDisplay(reversedLines);
    }

    private static List<String> getFileLines() {
        try {
            return Files.readAllLines(FILE_PATH);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }

    private static List<String> writeAndGetReversed(List<String> fileLines) {
        try {
            Files.createFile(REVERSED_FILE_PATH);
            List<String> reversedLines = new ArrayList<>();
            for (String line : fileLines) {
                String reversedLine = new StringBuilder(line).reverse().toString();
                reversedLines.add(reversedLine);
                Files.writeString(REVERSED_FILE_PATH, reversedLine + "\n", StandardOpenOption.APPEND);
            }
            return reversedLines;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return Collections.emptyList();
    }
}