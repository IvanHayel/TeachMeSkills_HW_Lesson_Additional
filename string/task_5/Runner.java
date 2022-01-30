package string.task_5;

import string.task_5.util.manipulator.StringManipulator;

/**
 * In each sentence of the text, swap the first word with the last.
 */

public class Runner {
    public static void main(String[] args) {
        String text =
                    """
                    Tightly manifest a crewmate.
                    All of those aliens influence proud, post-apocalyptic species.
                    Domesticus vigils ducunt ad hibrida.
                    Bubos tolerare in virundum!
                    I unite this faith, it's called most unusual nuclear flux.
                    """;
        StringManipulator manipulator = StringManipulator.getInstance();
        String changedText = manipulator.swapFirstLastWordEachSentence(text);
        System.out.println("Original:\n" + text + "\n");
        System.out.println("After replacement:\n" + changedText + "\n");
    }
}