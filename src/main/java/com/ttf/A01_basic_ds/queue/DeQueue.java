package com.ttf.A01_basic_ds.queue;

import com.ttf.A01_basic_ds.list.DoubleNode;

/**
 * Double ended queue implemented by doubly linked list.
 * So it will based on DoubleNode.
 *
 * A DeQueue will have a head and tail, and 4 main operations:
 * add and pop from head, add and pop from tail.
 *
 * DeQueue can be used to implement queue and stack.
 */
public class DeQueue<T> {
    DoubleNode<T> head;
    DoubleNode<T> tail;
    // how many elements in the queue
    int size;

    /**
     * add a new node from head
     * @param value
     */
    public void addFromHead(T value) {
        DoubleNode<T> node = new DoubleNode<T>(value);
        if (head == null) { // for empty queue
            head = node;
            tail = node;
        } else {
            node.setPre(head);
            head.setNext(node);
            head = node;
            this.size ++;
        }
    }

    /**
     * add a new node from tail
     * @param value
     */
    public void addFromTail(T value) {
        DoubleNode<T> node = new DoubleNode<T>(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.setNext(tail);
            tail.setPre(node);
            tail = node;
            this.size ++;
        }
    }

    /**
     * pop up head node from queue
     * @return
     */
    public T popHead(){
        if (head==null){ // empty queue
            return null;
        }
        DoubleNode<T> cur = head;
        if (head == tail) { // only one node
            head = null;
            tail = null;
        } else {
            head = cur.getPre();
            cur.setPre(null);
            head.setNext(null);
        }
        this.size --;
        return cur.getValue();
    }

    /**
     * pop up tail node from queue
     * @return
     */
    public T popTail(){
        if (tail==null){ // empty queue
            return null;
        }
        DoubleNode<T> cur = tail;
        if (head == tail) { // only one node
            head = null;
            tail = null;
        } else {
            tail = cur.getNext();
            cur.setNext(null);
            tail.setPre(null);
        }
        this.size --;
        return cur.getValue();
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int size() {
        return this.size;
    }

}
