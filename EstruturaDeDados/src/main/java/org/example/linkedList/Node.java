package org.example.linkedList;

public class Node {
    private Integer element;
    private Node next;

    public Node(Integer element, Node linkedElement) {
        this.element = element;
        this.next = linkedElement;
    }

    public Node(Integer element) {
        this.element = element;
    }

    public Integer getElement() {
        return element;
    }

    public void setElement(Integer element) {
        this.element = element;
    }

    public Node getLinkedElement() {
        return next;
    }

    public void setLinkedElement(Node linkedElement) {
        this.next = linkedElement;
    }

    @Override
    public String toString() {
        return "Node{" +
                "element=" + element +
                ", linkedElement=" + next +
                '}';
    }
}
