package com.ttf.stack;

/**
 * Basic stack implementation using a fixed array
 */
public class MyStack<T> {

    // arr to store elements
    private Object arr[];

    // the max length of the stack
    private final int length;

    // the number of elements in the stack
    private int size;

    // index for top element
    private int top;

    public MyStack(int length) {
        this.arr = new Object[length];
        this.length = length;
        this.size = 0;
        this.top = -1;// initial set to -1 to indicate there is not element in the stack
    }

    public T push(T e) {
        if (size == length) {
            throw new RuntimeException("Stack is full");
        }
        arr[++top] = e;
        size++;
        return e;
    }

    public T pop() {
        if (size == 0) {
            throw new RuntimeException("Stack is empty");
        }
        Object e = arr[top];
        top--;
        size--;
        return (T) e;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T peek() {
        if (size == 0) {
            throw new RuntimeException("Stack is empty");
        }
        return (T) arr[top];
    }

    public static void main(String[] args){
        MyStack<Integer> myStack=new MyStack<Integer>(5);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);

        System.out.println(myStack.peek());
        myStack.pop();
        System.out.println(myStack.peek());
        myStack.pop();
        System.out.println(myStack.peek());
        myStack.pop();

        myStack.push(6);
        System.out.println(myStack.peek());



    }

}
