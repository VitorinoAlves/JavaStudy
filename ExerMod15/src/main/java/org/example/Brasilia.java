package org.example;

public class Brasilia implements ICar{
    @Override
    public void assemble() {
        System.out.println("Assembling a Brasilia.");
    }

    @Override
    public void paint(String color) {
        System.out.println("Painting the Brasilia of color " + color);
    }

    @Override
    public void deliver() {
        System.out.println("Delivering the Brasilia to the customer");
    }
}
