package stream.task_1.model.car;

import util.display.PageViewer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public final class Cars {
    private static final Scanner CONSOLE_INPUT = new Scanner(System.in);
    private List<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public void loadCars(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path);
        for (String line : lines) {
            String[] carInfo = line.split("\\|");
            if (carInfo.length == 5) {
                String name = carInfo[0];
                Year issueYear = Year.parse(carInfo[1]);
                int price = Integer.parseInt(carInfo[2]);
                String color = carInfo[3];
                double engineCapacity = Double.parseDouble(carInfo[4]);
                cars.add(new Car(name, issueYear, price, color, engineCapacity));
            }
        }
    }

    public void displayCars() {
        PageViewer.pageDisplay(cars);
    }

    public void searchCarsByColor() {
        System.out.println("\n SEARCH BY COLOR");
        System.out.print("Enter color -> ");
        String color = CONSOLE_INPUT.nextLine().strip();
        List<Car> carsByColor = cars.stream()
                .filter(car -> car.getColor().equalsIgnoreCase(color))
                .toList();
        if (carsByColor.isEmpty()) {
            System.out.println("There is no cars with " + color + " color...");
        } else {
            System.out.println("Cars with " + color + " color:");
            PageViewer.pageDisplay(carsByColor);
        }
    }

    public void searchFromPrice() {
        System.out.println("\n SEARCH FROM PRICE");
        System.out.print("Enter minimum price -> ");
        int price = Integer.parseInt(CONSOLE_INPUT.nextLine().strip());
        List<Car> carsFromPrice = cars.stream()
                .filter(car -> car.getPrice() >= price)
                .toList();
        if (carsFromPrice.isEmpty()) {
            System.out.println("There is no cars with price more than " + price + "...");
        } else {
            System.out.println("Cars over " + price + ":");
            PageViewer.pageDisplay(carsFromPrice);
        }
    }

    public void searchByIssueYear() {
        System.out.println("\n SEARCH BY ISSUE YEAR RANGE");
        System.out.print("Enter from -> ");
        Year from = Year.parse(CONSOLE_INPUT.nextLine().strip());
        System.out.print("Enter to -> ");
        Year to = Year.parse(CONSOLE_INPUT.nextLine().strip());
        List<Car> carsByIssueYear = cars.stream()
                .filter(car -> car.getIssueYear().isAfter(from) && car.getIssueYear().isBefore(to))
                .toList();
        if (carsByIssueYear.isEmpty()) {
            System.out.println("There is no cars with issue year in range " + from + " - " + to + "...");
        } else {
            System.out.println("Cars with issue year in range " + from + " - " + to + ":");
            PageViewer.pageDisplay(carsByIssueYear);
        }
    }

    public void sortCarsByPrice() {
        cars = cars.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}