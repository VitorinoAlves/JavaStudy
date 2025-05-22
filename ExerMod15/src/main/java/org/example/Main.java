package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ICarFactory carFactory = null;
        System.out.println("Choose a car to be delivered by informing the number, 1-Brasilia or 2-Corolla:");
        int numOption = scanner.nextInt();

        if(numOption == 1){
            carFactory = new BrasiliaCarFactory();
        } else if (numOption == 2){
            carFactory = new CorollaCarFactory();
        } else {
            System.out.println("Invalid option");
        }

        if(carFactory != null){
            ICar car = carFactory.createCar();
            car.assemble();
            car.paint("White");
            car.deliver();
        }

    }
}