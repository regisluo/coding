package com.ttf.stack;

/**
 * normal stack implementation based on array with getMin function which will
 * return the minimum number in the stack with a O(1) time complexy
 */
public class StackBasedOnArrayWithGetMin {
    private int[] arr;
    private int[] min; // array to store minimum number
    private int size; // the current number of elements in the stack
    private final int length; // max length of the stack
    private int top; // current index pointing to the top element

    public StackBasedOnArrayWithGetMin(int length) {
        this.length = length;
        arr = new int[length];
        min = new int[length];
        this.size = 0;
        this.top = -1;
    }

    // add an element into the stack
    private void push(int value) {
        if (size == length) {
            throw new RuntimeException("stack full");
        }
        arr[top + 1] = value;
        // push minimum of (min[top], value) into min array
        if (top == -1) {
            min[top + 1] = value;
        }else {
            min[top + 1] = value<min[top]?value:min[top];
        }
        size++;
        top++;
    }

    // remove an element from the stackc
    private int pop() {
        if (size == 0) {
            throw new RuntimeException("stack empty");
        }
        int value = arr[top];
        top--;
        size--;
        return value;
    }

    private int getMin(){
        if (size == 0) {
            throw new RuntimeException("stack empty");
        }
        int value = min[top];
        return value;
    }

    private int peek() {
        if (size == 0) {
            throw new RuntimeException("stack empty");
        }
        return this.arr[top];
    }

    private boolean empty() {
        return size == 0;
    }

    public static void main(String[] args) {
        StackBasedOnArrayWithGetMin stack = new StackBasedOnArrayWithGetMin(5);

        stack.push(3);
        stack.push(5);
        stack.push(2);
        System.out.println("Min="+stack.getMin());

        stack.push(4);
        System.out.println("Min="+stack.getMin());

        stack.push(1);
        System.out.println("Min="+stack.getMin());

        stack.pop();
        System.out.println("Min="+stack.getMin());

    }

}
