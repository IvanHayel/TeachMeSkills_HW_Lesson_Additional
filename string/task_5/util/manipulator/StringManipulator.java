package string.task_5.util.manipulator;

import java.util.*;
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

    public String swapFirstLastWordEachSentence(String text) {
        LinkedList<String> sentences = getSentences(text);
        StringBuilder builder = new StringBuilder();
        for (String sentence : sentences) {
            LinkedList<String> words = getWords(sentence);
            swapFirstLast(words);
            String modifiedSentence = modifySentenceWithNewWords(sentence, words);
            builder.append(modifiedSentence);
        }
        return builder.toString();
    }

    public LinkedList<String> getSentences(String text) {
        LinkedList<String> sentences = new LinkedList<>();
        Pattern pattern = Pattern.compile("([^?.!]+)([?.!\n]+)");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            sentences.addLast(matcher.group());
        }
        return sentences;
    }

    public LinkedList<String> getWords(String text) {
        LinkedList<String> words = new LinkedList<>();
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            words.addLast(matcher.group());
        }
        return words;
    }

    private void swapFirstLast(LinkedList<String> list) {
        String temp = list.removeFirst();
        list.addFirst(list.removeLast());
        list.addLast(temp);
    }

    private String modifySentenceWithNewWords(String sentence, LinkedList<String> words) {
        LinkedList<String> wordsCopy = (LinkedList<String>) words.clone();
        Pattern pattern = Pattern.compile("(\\w+)(\\W+)");
        Matcher matcher = pattern.matcher(sentence);
        StringBuilder builder = new StringBuilder();
        while (matcher.find()) {
            builder.append(wordsCopy.removeFirst());
            builder.append(matcher.group(2));
        }
        return builder.toString();
    }
}