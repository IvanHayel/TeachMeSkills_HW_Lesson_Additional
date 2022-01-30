package collections.task_1;

import collections.task_1.model.distinct.DistinctWords;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The file with the text in English is given. Select all different words.
 * Words that differ only in letter case are considered the same.
 * Use the HashSet class.
 */

public class Runner {
    private static final Path simpleText =
            Paths.get("src/main/java/collections/task_1/resources/texts/SimpleText.txt");
    private static final Path hardText =
            Paths.get("src/main/java/collections/task_1/resources/texts/HardText.txt");

    public static void main(String[] args) {
        DistinctWords simpleExample = new DistinctWords(simpleText);
        DistinctWords hardExample = new DistinctWords(hardText);
        simpleExample.displayInformation();
        hardExample.displayInformation();
    }
}