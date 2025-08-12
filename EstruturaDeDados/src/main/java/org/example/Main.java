package org.example;

import org.example.linkedList.LinkedList;

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

        System.out.println("Testando LinkedList");
        LinkedList linkedList = new LinkedList();

        linkedList.push(8);
        linkedList.push(6);
        linkedList.push(4);
        linkedList.push(7);
        linkedList.push(9);
        linkedList.printList();
        System.out.println("--------------------");
        linkedList.pop();
        linkedList.pop();
        linkedList.printList();
        System.out.println("--------------------");
        linkedList.push(46);
        linkedList.push(54);
        linkedList.push(77);
        linkedList.insert(2, 2);
        linkedList.printList();
        System.out.println("--------------------");
        linkedList.remove(4);
        linkedList.printList();
        System.out.println("--------------------");
        System.out.println(linkedList.elementAt(3));
        System.out.println(linkedList.size());

    }
}