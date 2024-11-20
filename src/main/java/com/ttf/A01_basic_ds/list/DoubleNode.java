package com.ttf.A01_basic_ds.list;

public class DoubleNode<T> {
    private T value;
    private DoubleNode<T> pre;
    private DoubleNode<T> next;

    public DoubleNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public DoubleNode<T> getPre() {
        return pre;
    }

    public void setPre(DoubleNode<T> pre) {
        this.pre = pre;
    }

    public DoubleNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }
}
