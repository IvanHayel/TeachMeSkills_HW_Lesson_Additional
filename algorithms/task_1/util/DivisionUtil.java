package algorithms.task_1.util;

import algorithms.task_1.model.division.Quotient;

import static java.lang.Math.abs;

public final class DivisionUtil {
    private DivisionUtil() {
    }

    // Division using repeated subtraction.
    public static Quotient divideByRepeating(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero!");
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return new Quotient(Integer.MAX_VALUE, 0);
        }
        if (divisor < 0) {
            Quotient quotient = divideByRepeating(dividend, negate(divisor));
            return new Quotient(negate(quotient.getInteger()), quotient.getRemainder());
        }
        if (dividend < 0) {
            Quotient quotient = divideByRepeating(negate(dividend), divisor);
            if (quotient.getRemainder() == 0) {
                return new Quotient(quotient.getInteger(), 0);
            } else {
                return new Quotient(negate(quotient.getInteger()), negate(quotient.getRemainder()));
            }
        }
        return divideByRepeatingUnsigned(dividend, divisor);
    }

    private static int negate(int value) {
        return (-1) * value;
    }

    private static Quotient divideByRepeatingUnsigned(int dividend, int divisor) {
        int integer = 0;
        int remainder = dividend;
        while (remainder >= divisor) {
            integer++;
            remainder -= divisor;
        }
        return new Quotient(integer, remainder);
    }

    // Division using cycle
    public static Quotient divideByCycle(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero!");
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return new Quotient(Integer.MAX_VALUE, 0);
        }
        int integerSign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        int remainderSign = ((dividend < 0) || (divisor < 0)) ? -1 : 1;
        long dividendUnsigned = abs(dividend);
        int divisorUnsigned = abs(divisor);
        int integerUnsigned = 0;
        while (dividendUnsigned >= divisorUnsigned) {
            dividendUnsigned -= divisorUnsigned;
            integerUnsigned++;
        }
        int integer = integerSign * integerUnsigned;
        int remainder = remainderSign * (abs(dividend) - integerUnsigned * divisorUnsigned);
        return new Quotient(integer, remainder);
    }

    // Division using bitwise operator
    public static Quotient divideByBitwise(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero!");
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return new Quotient(Integer.MAX_VALUE, 0);
        }
        int integerSign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        int remainderSign = ((dividend < 0) || (divisor < 0)) ? -1 : 1;
        long dividendUnsigned = abs(dividend);
        long divisorUnsigned = abs(divisor);
        int integerUnsigned = 0;
        int temp = 1;
        while (divisorUnsigned <= dividendUnsigned) {
            divisorUnsigned <<= 1;
            temp <<= 1;
        }
        while (temp > 1) {
            divisorUnsigned >>= 1;
            temp >>= 1;
            if (dividendUnsigned >= divisorUnsigned) {
                dividendUnsigned -= divisorUnsigned;
                integerUnsigned += temp;
            }
        }
        int integer = integerSign * integerUnsigned;
        int remainder = (int) (remainderSign * (abs(dividend) - integerUnsigned * divisorUnsigned));
        return new Quotient(integer, remainder);
    }
}