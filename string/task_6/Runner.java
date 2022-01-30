package string.task_6;

/**
 * Remove from the text all words of a given length that begin with a consonant.
 */

public class Runner {
    private static final int REMOVE_LENGTH = 3;

    public static void main(String[] args) {
        String text = "The ship is more kahless now than sun. ordinary and oddly terrifying.";
        String changedText = removeWords(text);
        System.out.println("Original: " + text);
        System.out.println("After replacement: " + changedText);
    }

    private static String removeWords(String text) {
        String regex = "\\b\\w{" + REMOVE_LENGTH + "}\\b";
        return text.replaceAll(regex, "");
    }
}