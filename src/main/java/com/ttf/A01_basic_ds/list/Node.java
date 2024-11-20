package com.ttf.A01_basic_ds.list;

/**
 * Single Node structure.
 * Can be refactored to be implemented with generic.
 */
public class Node {
    private int value;
    private Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    void delete(Node head, int d){

    }

    private void appendToTail(int i) {
        Node node = new Node(i);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = node;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node next() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
