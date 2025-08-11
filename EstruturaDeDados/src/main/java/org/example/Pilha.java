package org.example;

import java.util.ArrayList;
import java.util.List;

public class Pilha {
    private List<Integer> pilha;

    public Pilha(){
        pilha = new ArrayList<>();
    }

    public void push(int element){
        this.pilha.add(element);
    }

    public void pop(){
        this.pilha.remove(pilha.size()-1);
    }

    public Integer top() {
        return pilha.get(pilha.size()-1);
    }

    public Boolean isEmpty() {
        return pilha.isEmpty();
    }

    public Integer size() {
        return pilha.size();
    }

    public void printPilha() {
        System.out.println(this.pilha);
    }
}
