package string.task_1.util.manipulator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringManipulator {
    private static StringManipulator instance;

    private StringManipulator() {
    }

    public static StringManipulator getInstance() {
        if (instance == null) {
            instance = new StringManipulator();
        }
        return instance;
    }

    public String replaceLetterInAllWords(String source, int letterSerialNumber, char replacement) {
        Pattern pattern = Pattern.compile("(\\w+)(\\W+)");
        Matcher matcher = pattern.matcher(source);
        StringBuilder builder = new StringBuilder();
        while (matcher.find()) {
            String word = matcher.group(1);
            word = replaceLetterInSingleWord(word, letterSerialNumber, replacement);
            builder.append(word);
            String separators = matcher.group(2);
            builder.append(separators);
        }
        return builder.toString();
    }

    public String replaceLetterInSingleWord(String word, int letterSerialNumber, char replacement) {
        char[] array = word.toCharArray();
        if (array.length >= letterSerialNumber && letterSerialNumber > 0) {
            array[letterSerialNumber-1] = replacement;
            return new String(array);
        }
        return word;
    }
}