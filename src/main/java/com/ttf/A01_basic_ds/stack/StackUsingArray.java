package com.ttf.A01_basic_ds.stack;

public class StackUsingArray {
    private int[] arr;
    private int size; // the current number of elements in the stack
    private final int length; // max length of the stack
    private int top; // current index pointing to the top element

    public StackUsingArray(int length) {
        this.length = length;
        arr = new int[length];
        this.size = 0;
        this.top = -1;
    }

    // add an element into the stack
    public void push(int value) {
        if (size == length) {
            throw new RuntimeException("stack full");
        }
        arr[top + 1] = value;
        size++;
        top++;
    }

    // remove an element from the stack
    public int pop() {
        if (size == 0) {
            throw new RuntimeException("stack empty");
        }
        int value = arr[top];
        top--;
        size--;
        return value;
    }

    public int peek() {
        if (size == 0) {
            throw new RuntimeException("stack empty");
        }
        return this.arr[top];
    }

    public boolean empty() {
        return size == 0;
    }

}
