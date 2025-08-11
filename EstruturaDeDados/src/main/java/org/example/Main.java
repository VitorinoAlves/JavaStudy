package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Testando a pilha");
        Pilha pilha = new Pilha();

        pilha.push(5);
        pilha.push(8);
        pilha.push(7);
        pilha.push(4);
        pilha.push(3);

        pilha.printPilha();
        pilha.pop();
        pilha.pop();
        pilha.push(9);
        pilha.printPilha();

        System.out.println("Testando a FIFO");
        Fifo fila = new Fifo();
        fila.enqueue(5);
        fila.enqueue(8);
        fila.enqueue(7);
        fila.enqueue(4);
        fila.enqueue(3);

        fila.printFIFO();
        System.out.println(fila.front());
        System.out.println(fila.rear());
        fila.dequeue();
        fila.dequeue();
        fila.printFIFO();
        System.out.println(fila.front());
        System.out.println(fila.rear());

    }
}