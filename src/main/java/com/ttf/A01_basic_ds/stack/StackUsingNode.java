package com.ttf.A01_basic_ds.stack;

import com.ttf.A01_basic_ds.list.SingleNode;

public class StackUsingNode {
    private SingleNode top;

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
        SingleNode n = new SingleNode(i);
        n.setNext(top);
        top = n;

    }
}
