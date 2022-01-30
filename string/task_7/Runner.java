package string.task_7;

/**
 * Write a Java program to remove all spaces from a string using replace().
 */

public class Runner {
    public static void main(String[] args) {
        String text = "Red alert, futile voyage!";
        String changedText = removeSpaces(text);
        String sample = text.replaceAll(" ", "");
        System.out.println("Original: " + text);
        System.out.println("After replacement (variant 1): " + changedText);
        System.out.println("After replacement (variant 2): " + sample);
    }

    private static String removeSpaces(String text) {
        while(text.contains(" ")){
            text = text.replace(" ", "");
        }
        return text;
    }
}