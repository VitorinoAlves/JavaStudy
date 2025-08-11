package org.example.linkedList;

public class Node {
    private Integer element;
    private Node linkedElement;

    public Node(Integer element, Node linkedElement) {
        this.element = element;
        this.linkedElement = linkedElement;
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
        return linkedElement;
    }

    public void setLinkedElement(Node linkedElement) {
        this.linkedElement = linkedElement;
    }

    @Override
    public String toString() {
        return "Node{" +
                "element=" + element +
                ", linkedElement=" + linkedElement +
                '}';
    }
}
