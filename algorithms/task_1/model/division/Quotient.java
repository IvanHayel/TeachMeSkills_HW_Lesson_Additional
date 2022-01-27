package algorithms.task_1.model.division;

public class Quotient {
    private int integer;
    private int remainder;

    public Quotient(int integer, int remainder) {
        this.integer = integer;
        this.remainder = remainder;
    }

    public int getInteger() {
        return integer;
    }

    public int getRemainder() {
        return remainder;
    }

    @Override
    public String toString() {
        return "Integer: " + integer + " Remainder: " + remainder;
    }
}