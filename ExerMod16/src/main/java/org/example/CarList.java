package org.example;

import java.util.ArrayList;
import java.util.List;

public class CarList<T extends Car>{
    private List<T> cars;

    public CarList() {
        this.cars = new ArrayList<>();
    }

    public void addCar(T car){
        this.cars.add(car);
    }

    public void displayAllCars(){
        if(cars.isEmpty()){
            System.out.println("The car List is empty");
            return;
        }
        System.out.println("Car List:");
        for (T car : this.cars){
            System.out.println(car);
        }
    }


}
