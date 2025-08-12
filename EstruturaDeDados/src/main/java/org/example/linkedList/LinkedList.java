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

    public Integer pop() {
        if (incio == null) {
            return null;
        }

        if(size == 1) {
            System.out.println("Unico elemento removido");
            size--;
            return incio.getElement();
        } else {
            Node atual = incio;
            while (atual.getLinkedElement().getLinkedElement() != null) {
                atual = atual.getLinkedElement();
            }
            Node nodeToBeRemoved = atual.getLinkedElement();
            atual.setLinkedElement(null);
            size--;
            return nodeToBeRemoved.getElement();
        }
    }

    public void insert (Integer element, Integer index) {
        if(index < 0 || index > size) {
            System.out.println("Index informado não existe");
            return;
        }

        Node nodeAtual = incio;
        for (int i=0; i<index-1; i++) {
            nodeAtual = nodeAtual.getLinkedElement();
        }

        Node newNode = new Node(element);
        newNode.setLinkedElement(nodeAtual.getLinkedElement());
        nodeAtual.setLinkedElement(newNode);
        size++;
    }

    public void remove(Integer index) {
        if(index < 0 || index > size) {
            System.out.println("Index informado não existe");
            return;
        }

        Node nodeAtual = incio;
        for (int i=0; i<index-1; i++) {
            nodeAtual = nodeAtual.getLinkedElement();
        }
        nodeAtual.setLinkedElement(nodeAtual.getLinkedElement().getLinkedElement());
        size--;

    }

    public Integer elementAt(Integer index) {
        if(index < 0 || index > size) {
            System.out.println("Index informado não existe");
            return null;
        }

        Node nodeAtual = incio;
        for (int i=0; i<index; i++) {
            nodeAtual = nodeAtual.getLinkedElement();
        }
        return nodeAtual.getElement();
    }

    public Integer size() {
        return this.size;
    }

    public void printList() {
        if(incio == null) {
            System.out.println("A lista esta vazia");
            return;
        } else {
            Node atual = incio;
            for (int i=0; i<size; i++) {
                System.out.println(atual.getElement());
                atual = atual.getLinkedElement();
            }
        }
    }
}
