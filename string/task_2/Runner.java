package string.task_2;

import string.task_2.util.manipulator.StringManipulator;

/**
 * In the text, replace each letter with its ordinal number in the alphabet.
 */

public class Runner {
    public static void main(String[] args) {
        String text = "Altus exemplar mechanice examinares agripeta est.";
        StringManipulator manipulator = StringManipulator.getInstance();
        String changedText = manipulator.replaceWithAlphabetOrdinalNumbers(text);
        System.out.println("Original: " + text);
        System.out.println("After replacement: " + changedText);
    }
}