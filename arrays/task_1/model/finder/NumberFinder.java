package arrays.task_1.model.finder;

import java.util.Arrays;

public final class NumberFinder {
    private static NumberFinder instance;

    private NumberFinder() {
    }

    public static NumberFinder getInstance() {
        if (instance == null) {
            instance = new NumberFinder();
        }
        return instance;
    }

    public int getSecondLargestNumber(int[] array) {
        return Arrays.stream(array)
                .boxed()
                .sorted((firstNumber, secondNumber) -> secondNumber - firstNumber)
                .skip(1)
                .mapToInt(Integer::intValue)
                .findFirst()
                .orElseThrow(ArrayIndexOutOfBoundsException::new);
    }
}