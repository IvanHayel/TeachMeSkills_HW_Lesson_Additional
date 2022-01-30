package string.task_2.util.manipulator;

import java.util.HashMap;
import java.util.Map;

public final class StringManipulator {
    private static StringManipulator instance;
    private static Map<Integer, Integer> alphabet;

    private StringManipulator() {
        alphabet = getAlphabet();
    }

    public static StringManipulator getInstance() {
        if (instance == null) {
            instance = new StringManipulator();
        }
        return instance;
    }

    public String replaceWithAlphabetOrdinalNumbers(String text) {
        StringBuilder builder = new StringBuilder();
        text.chars()
                .mapToObj(el -> {
                    if (alphabet.containsKey(el)) {
                        int ordinalNumber = alphabet.get(el);
                        return ordinalNumber + "|";
                    }
                    return String.valueOf((char) el);
                })
                .forEach(builder::append);
        return builder.toString();
    }

    private Map<Integer, Integer> getAlphabet() {
        Map<Integer, Integer> alphabet = new HashMap<>();
        for (int codeUpperCase = 65, codeLowerCase = 97, counter = 1;
             codeUpperCase <= 90 && codeLowerCase <= 122 && counter < 26;
             codeUpperCase++, codeLowerCase++, counter++)
        {
            alphabet.put(codeLowerCase, counter);
            alphabet.put(codeUpperCase, counter);
        }
        return alphabet;
    }
}