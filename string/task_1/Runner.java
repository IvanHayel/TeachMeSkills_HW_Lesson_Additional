package string.task_1;

import string.task_1.util.manipulator.StringManipulator;

/**
 * In each word of the text, replace the k-th letter with the given character.
 * If k is greater than the word length, no adjustment is made.
 */

public class Runner {
    public static void main(String[] args) {
        String text = "This flight has only been dissolved by a brave creature. Rise quietly, like a undead corsair.";
        StringManipulator manipulator = StringManipulator.getInstance();
        String changedText = manipulator.replaceLetterInAllWords(text,3,'X');
        System.out.println("Original: " + text);
        System.out.println("After replacement: " + changedText);
    }
}