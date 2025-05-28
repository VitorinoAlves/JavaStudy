package org.example;

public abstract class Car {
    private String model;
    private String color;
    private Integer horsePower;
    private String fuelType;

    public Car(String model, String color, Integer horsePower, String fuelType) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.fuelType = fuelType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", horsePower=" + horsePower +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }
}
