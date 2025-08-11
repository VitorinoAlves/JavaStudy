package org.example.linkedList;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {
    private Node incio;
    private int size;

    public LinkedList() {
        this.incio = null;
        this.size = 0;
    }

    public void push(Integer element) {
        Node newNode = new Node(element);
        if(incio == null) {
            incio = newNode;
        } else {
            Node atual = incio;
            while (atual.getLinkedElement() != null) {
                atual = atual.getLinkedElement();
            }
            atual.setLinkedElement(newNode);
        }
        size++;
    }

    public void pop() {
        if (incio == null) {
            return;
        }

        if(size == 1) {
            System.out.println("Unico elemento removido");
        } else {
            Node atual = incio;
            while (atual.getLinkedElement().getLinkedElement() != null) {
                atual = atual.getLinkedElement();
            }
            atual.setLinkedElement(null);
        }
    }
}
