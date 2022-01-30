package arrays.task_1;

import arrays.task_1.model.finder.NumberFinder;

import java.util.Arrays;

/**
 * Write a Java program to find the second-largest number in an array.
 */

public class Runner {
    public static void main(String[] args) {
        int[] array = {581, 993, 604, 497, 834, 670, 217, 264, 888, 991, 612, 966};

        NumberFinder finder = NumberFinder.getInstance();
        int secondLargestNumber = finder.getSecondLargestNumber(array);

        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Second largest number: " + secondLargestNumber);
    }
}