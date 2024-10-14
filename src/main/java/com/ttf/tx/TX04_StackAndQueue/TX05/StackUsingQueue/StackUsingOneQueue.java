package com.ttf.tx.TX04_StackAndQueue.TX05.StackUsingQueue;

import java.util.LinkedList;
import java.util.Queue;

// key point is "cha dui":
// as enqueue is to the rear, so after that, move the new element to the front
// then the following dequeue will take element from the front to simulate the stack behavior (LIFO)
public class StackUsingOneQueue {
    private Queue<Integer> queue;

    public StackUsingOneQueue(){
        this.queue = new LinkedList<>();
    }

    // time complexity is O(n)
    public void push(int data){
        // rotate the queue so the last element is at the front
        int size = queue.size();
        queue.offer(data);
        for (int i=0;i<size;i++){
            queue.offer(queue.poll());
        }
    }

    private int pop(){
        if (queue.isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return queue.poll();
    }

    private int peek(){
        if (queue.isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return queue.poll();
    }

    private boolean isEmpty(){
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingOneQueue stack = new StackUsingOneQueue();

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Peek the top element
        System.out.println("Top element is: " + stack.peek());  // Output: 30

        // Pop elements from the stack
        System.out.println("Popped element: " + stack.pop());  // Output: 30
        System.out.println("Top element after pop: " + stack.peek());  // Output: 20
    }

}
