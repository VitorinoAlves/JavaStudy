package org.example;

public class CorollaCar implements ICar{
    @Override
    public void assemble() {
        System.out.println("Assembling a Corolla.");
    }

    @Override
    public void paint(String color) {
        System.out.println("Painting the Corolla of color " + color);
    }

    @Override
    public void deliver() {
        System.out.println("Delivering the Corolla to the customer");
    }
}
