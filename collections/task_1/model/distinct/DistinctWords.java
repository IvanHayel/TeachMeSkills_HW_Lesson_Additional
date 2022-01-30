package collections.task_1.model.distinct;

import util.display.PageViewer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class DistinctWords {
    private Path textFilePath;
    private Set<String> distinctWords;
    private int quantity;

    public DistinctWords(Path textFilePath) {
        if (isTextFile(textFilePath)) {
            this.textFilePath = textFilePath;
            quantity = 0;
            distinctWords = new HashSet<>();
            try {
                getWords(textFilePath);
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
        } else {
            throw new RuntimeException(textFilePath + " not a text file (.txt)!");
        }
    }

    private static boolean isTextFile(Path filePath) {
        return filePath.toString().endsWith(".txt");
    }

    private void getWords(Path textFilePath) throws IOException {
        String text = Files.readString(textFilePath);
        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String word = matcher.group().toLowerCase();
            distinctWords.add(word);
            quantity++;
        }
    }

    public void displayInformation() {
        System.out.println("\n" + textFilePath.getFileName() + " information");
        System.out.println("Total words scanned: " + quantity);
        System.out.println("Distinct words: " + distinctWords.size());
        PageViewer.pageDisplay(distinctWords);
    }
}