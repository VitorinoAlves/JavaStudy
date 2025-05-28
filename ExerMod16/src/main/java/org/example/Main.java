package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CarList<Car> carList = new CarList<>();

        carList.addCar(new Civic("Civic G10", "White", 200, "Gas"));
        carList.addCar(new Brasilia("Brasilia", "Yellow", 200, "Gas"));
        carList.addCar(new Dolphin("Dolphin Plus", "Black", 200, "Electric"));

        carList.displayAllCars();
    }
}