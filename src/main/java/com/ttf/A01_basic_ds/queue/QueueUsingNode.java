package com.ttf.A01_basic_ds.queue;

import com.ttf.A01_basic_ds.list.SingleNode;

public class QueueUsingNode {
    private SingleNode head;
    private SingleNode tail;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty(){
        return head==null;
    }

    public void enque(int i) {
        SingleNode n = new SingleNode(i);
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
