package com.ttf.A00_review.common;
// the data node of the queue
public class Node <T>{
    T data;
    Node<T> prev;
    Node<T> next;

    // construct
    public Node(T data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
