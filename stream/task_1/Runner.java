package stream.task_1;

import stream.task_1.model.car.Cars;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Create class "Car". The class should store the following information:
 * car name; year of issue; price; color; engine capacity.
 * You need to create a set of cars and perform the following tasks:
 * display all cars;
 * display vehicles of the specified color;
 * display cars more expensive than the specified price;
 * display cars whose year of manufacture is in the specified range;
 * sort cars in descending order of cost.
 * Solve problems using the Stream API application interface.
 */

public class Runner {
    private static final Path CARS_PATH =
            Paths.get("src/main/java/stream/task_1/data/cars.txt");

    public static void main(String[] args) {
        try {
            Cars cars = new Cars();
            cars.loadCars(CARS_PATH);
            cars.displayCars();
            cars.searchCarsByColor();
            cars.searchFromPrice();
            cars.searchByIssueYear();
            cars.sortCarsByPrice();
            cars.displayCars();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}