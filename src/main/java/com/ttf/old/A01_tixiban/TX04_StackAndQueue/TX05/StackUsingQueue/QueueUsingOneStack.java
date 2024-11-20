package com.ttf.old.A01_tixiban.TX04_StackAndQueue.TX05.StackUsingQueue;

import java.util.Stack;

// using recursive, not efficient as using two stacks
public class QueueUsingOneStack {
    private Stack<Integer> stack;

    // Constructor to initialize the stack
    public QueueUsingOneStack() {
        stack = new Stack<>();
    }

    // Enqueue an element into the queue
    public void enqueue(int data) {
        stack.push(data);
    }

    // Dequeue an element from the queue (using recursion)
    public int dequeue() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        // Base case: If this is the last element, return it
        if (stack.size() == 1) {
            return stack.pop();
        }

        // Recursive case: Pop all elements except the first, and then re-add them
        int top = stack.pop();
        int result = dequeue();  // Recursively remove elements until the first one
        stack.push(top);  // Push back the other elements

        return result;  // Return the first element
    }

    // Peek the front element of the queue (using recursion)
    public int peek() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        // Base case: If this is the last element, return it
        if (stack.size() == 1) {
            return stack.peek();
        }

        // Recursive case: Pop all elements except the first, and then re-add them
        int top = stack.pop();
        int result = peek();  // Recursively get the first element
        stack.push(top);  // Push back the other elements

        return result;  // Return the first element
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingOneStack queue = new QueueUsingOneStack();

        // Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // Peek the front element
        System.out.println("Front element is: " + queue.peek());  // Output: 10

        // Dequeue elements
        System.out.println("Dequeued element: " + queue.dequeue());  // Output: 10
        System.out.println("Front element after dequeue: " + queue.peek());  // Output: 20
    }
}
