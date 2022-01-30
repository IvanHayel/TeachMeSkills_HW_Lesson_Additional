package string.task_3;

/**
 * Find the sum of all occurring digits in the given text.
 */

public class Runner {
    public static void main(String[] args) {
        String text = "Repro23duc4e wildly like a most 1 unusual 3 phenomenan 2.";
        int sum = getSumOfDigits(text);
        System.out.println("Text: " + text);
        System.out.println("Sum of digits from text: " + sum);
    }

    private static int getSumOfDigits(String text) {
        int sum = 0;
        for (char character : text.toCharArray()) {
            if (Character.isDigit(character)) {
                sum += Character.getNumericValue(character);
            }
        }
        return sum;
    }
}