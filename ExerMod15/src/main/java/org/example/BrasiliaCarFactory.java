package org.example;

public class BrasiliaCarFactory implements ICarFactory{
    @Override
    public ICar createCar() {
        return new Brasilia();
    }
}
