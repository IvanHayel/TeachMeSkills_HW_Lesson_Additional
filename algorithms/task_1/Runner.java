package algorithms.task_1;

import algorithms.task_1.model.division.Quotient;
import algorithms.task_1.util.DivisionUtil;

import java.math.BigDecimal;

public class Runner {
    private static int dividend = -214748311;
    private static int divisor = -23;
    private static long startTimer;
    private static long endTimer;

    public static void main(String[] args) {
        testJavaDivision();
        testSubtractionRepeatDivision();
        testCycleDivision();
        testBitwiseDivision();
        testBigDecimalDivision();
    }

    private static void testJavaDivision() {
        System.out.println("Java division (" + dividend + " / " + divisor + ") result:");
        startTimer = System.nanoTime();
        int remainder = dividend % divisor;
        int integer = dividend / divisor;
        Quotient quotient = new Quotient(integer, remainder);
        endTimer = System.nanoTime() - startTimer;
        System.out.println(quotient);
        System.out.println("Time required: " + endTimer + " nanos.");
        System.out.println();
    }

    private static void testSubtractionRepeatDivision() {
        System.out.println("Division using repeated subtraction (" + dividend + " / " + divisor + ") result:");
        startTimer = System.nanoTime();
        Quotient quotient = DivisionUtil.divideByRepeating(dividend, divisor);
        endTimer = System.nanoTime() - startTimer;
        System.out.println(quotient);
        System.out.println("Time required: " + endTimer + " nanos.");
        System.out.println();
    }

    private static void testCycleDivision() {
        System.out.println("Division using cycle (" + dividend + " / " + divisor + ") result:");
        startTimer = System.nanoTime();
        Quotient quotient = DivisionUtil.divideByCycle(dividend, divisor);
        endTimer = System.nanoTime() - startTimer;
        System.out.println(quotient);
        System.out.println("Time required: " + endTimer + " nanos.");
        System.out.println();
    }

    private static void testBitwiseDivision() {
        System.out.println("Division using bitwise operator (" + dividend + " / " + divisor + ") result:");
        startTimer = System.nanoTime();
        Quotient quotient = DivisionUtil.divideByBitwise(dividend, divisor);
        endTimer = System.nanoTime() - startTimer;
        System.out.println(quotient);
        System.out.println("Time required: " + endTimer + " nanos.");
        System.out.println();
    }

    private static void testBigDecimalDivision() {
        System.out.println("Division using BigDecimal (" + dividend + " / " + divisor + ") result:");
        startTimer = System.nanoTime();
        BigDecimal dvd = BigDecimal.valueOf(dividend);
        BigDecimal dvs = BigDecimal.valueOf(divisor);
        BigDecimal[] result = dvd.divideAndRemainder(dvs);
        Quotient quotient = new Quotient(result[0].intValue(), result[1].intValue());
        endTimer = System.nanoTime() - startTimer;
        System.out.println(quotient);
        System.out.println("Time required: " + endTimer + " nanos.");
        System.out.println();
    }
}