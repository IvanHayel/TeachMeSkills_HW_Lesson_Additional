package string.task_8;

/**
 * Write a Java program to remove all spaces from a string without using replace().
 */

public class Runner {
    public static void main(String[] args) {
        String text = "Technically infiltrate a mermaid!";
        String changedText = removeSpaces(text);
        System.out.println("Original: " + text);
        System.out.println("After replacement: " + changedText);
    }

    private static String removeSpaces(String text) {
        StringBuilder builder = new StringBuilder();
        for (char character : text.toCharArray()) {
            if(character != ' '){
                builder.append(character);
            }
        }
        return builder.toString();
    }
}