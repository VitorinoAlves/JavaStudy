package org.example;

public class CorollaCarFactory implements ICarFactory{
    @Override
    public ICar createCar() {
        return new CorollaCar();
    }
}
