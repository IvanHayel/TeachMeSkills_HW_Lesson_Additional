package stream.task_1.model.car;

import java.time.Year;

public class Car implements Comparable<Car> {
    private String name;
    private Year issueYear;
    private int price;
    private String color;
    private double engineCapacity;

    public Car(String name, Year issueYear, int price, String color, double engineCapacity) {
        this.name = name;
        this.issueYear = issueYear;
        this.price = price;
        this.color = color;
        this.engineCapacity = engineCapacity;
    }

    public Year getIssueYear() {
        return issueYear;
    }

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    @Override
    public int compareTo(Car anotherCar) {
        return anotherCar.price - price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (price != car.price) return false;
        if (Double.compare(car.engineCapacity, engineCapacity) != 0) return false;
        if (!name.equals(car.name)) return false;
        if (!issueYear.equals(car.issueYear)) return false;
        return color.equals(car.color);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        result = 31 * result + issueYear.hashCode();
        result = 31 * result + price;
        result = 31 * result + color.hashCode();
        temp = Double.doubleToLongBits(engineCapacity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return name + " information: " +
                "year of issue - " + issueYear +
                "; price - " + price +
                "; engine capacity - " + String.format("%.2f", engineCapacity) +
                ".";
    }
}