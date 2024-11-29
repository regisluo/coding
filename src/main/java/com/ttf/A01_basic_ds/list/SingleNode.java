package com.ttf.A01_basic_ds.list;

/**
 * Single Node structure.
 * Can be refactored to be implemented with generic.
 */
public class SingleNode {
    private int value;
    private SingleNode next;

    public SingleNode(int value) {
        this.value = value;
        this.next = null;
    }

    void delete(SingleNode head, int d){

    }

    private void appendToTail(int i) {
        SingleNode node = new SingleNode(i);
        SingleNode n = this;
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

    public SingleNode next() {
        return next;
    }

    public void setNext(SingleNode next) {
        this.next = next;
    }
}
