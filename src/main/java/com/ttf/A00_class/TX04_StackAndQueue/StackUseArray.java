package com.ttf.A00_class.TX04_StackAndQueue;

public class StackUseArray {
    int[] stack;
    int top;
    int capacity;

    public StackUseArray(int capacity){
        this.capacity = capacity;
        stack = new int[this.capacity];
        this.top=-1;// indicate empty stack
    }

    private boolean isFull(){
        return this.top == capacity-1;
    }

    private boolean isEmpty(){
        return this.top==-1;
    }

    private void push(int data) {
        if (isFull()){
            throw new IllegalStateException("Stack is full");
        }
        this.stack[++top]=data;
    }

    private int pop(){
        if (isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }

        return this.stack[top--];
    }

    private int peek(){
        if (isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return this.stack[top];
    }

    private int size(){
        return this.top+1;
    }
}
