package string.task_4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Replace all identical adjacent characters in the text with a single character with a capital letter.
 */

public class Runner {
    public static void main(String[] args) {
        String text = "sttaanddd uuuppppp";
        String changedText = replaceRepeated(text);
        System.out.println("Original: " + text);
        System.out.println("After replacement: " + changedText);
    }

    private static String replaceRepeated(String text) {
        Pattern pattern = Pattern.compile("([a-zA-Z])\\1+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String replacement = matcher.group(1).toUpperCase();
            String group = matcher.group();
            text = text.replaceAll(group, replacement);
        }
        return text;
    }
}