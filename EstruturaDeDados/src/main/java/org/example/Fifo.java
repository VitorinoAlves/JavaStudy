package org.example;

import java.util.ArrayList;
import java.util.List;

public class Fifo {
    private List<Integer> fila;

    public Fifo() {
        this.fila = new ArrayList<>();
    }

    public void enqueue(Integer element) {
        this.fila.add(element);
    }

    public void dequeue() {
        this.fila.remove(0);
    }

    public Integer rear() {
        return this.fila.get(fila.size()-1);
    }

    public Integer front() {
        return this.fila.get(0);
    }

    public Integer size() {
        return this.fila.size();
    }

    public Boolean isEmpty() {
        return this.fila.isEmpty();
    }

    public void printFIFO() {
        System.out.println(this.fila);
    }
}
