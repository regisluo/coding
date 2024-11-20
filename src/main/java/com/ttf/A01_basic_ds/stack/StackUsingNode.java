package com.ttf.A01_basic_ds.stack;

import com.ttf.A01_basic_ds.list.Node;

public class StackUsingNode {
    private Node top;

    public int pop() throws Exception {
        if (top == null) {
            throw new Exception("Stack is empty");
        }
        int topValue = top.getValue();
        top = top.next();

        return topValue;
    }

    public int peek() throws Exception {
        if (top == null) {
            throw new Exception("Stack is empty");
        }
        return top.getValue();
    }

    public boolean isEmpty(){
        return top == null;
    }

    public void push(int i) {
        Node n = new Node(i);
        n.setNext(top);
        top = n;

    }
}
