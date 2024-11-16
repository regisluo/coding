package com.ttf.basic_ds.queue;

import com.ttf.basic_ds.list.Node;

public class QueueUsingNode {
    private Node head;
    private Node tail;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty(){
        return head==null;
    }

    public void enque(int i) {
        Node n = new Node(i);
        size ++;
        if (tail!=null)
            tail.setNext(n);
        tail = n;
        if (head == null)
            head = tail;
    }

    public int deque() throws Exception {
        if (head == null) {
            throw new Exception("Queue is empty.");
        }
        int i = head.getValue();
        head = head.next();
        size --;
        if (head==null)
            tail=null;
        return i;
    }

    public int peek() throws Exception {
        if (head == null) {
            throw new Exception("Queue is empty.");
        }
        return head.getValue();
    }



}
