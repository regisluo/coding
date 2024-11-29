package com.ttf.A00_class.TX04_StackAndQueue.TX05.StackUsingQueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueues {
    private Queue<Integer> queue;
    private Queue<Integer> help;

    public StackUsingTwoQueues(){
        queue = new LinkedList<>();
        help = new LinkedList<>();
    }

    // time complexity is O(n)
    // require extra space
    private void push(int data){
        queue.offer(data);
    }


    private int pop(){
        while (queue.size()>1) {
            help.offer(queue.poll());
        }
        int value = queue.poll();

        Queue<Integer> tmp = queue;
        queue = help;
        help = tmp;
        return value;
    }

    private int peek(){
        while (queue.size()>1) {
            help.offer(queue.poll());
        }
        int value = queue.poll();
        help.offer(value);
        Queue<Integer> tmp = queue;
        queue = help;
        help = tmp;
        return value;
    }

    private int size(){
        return queue.size();
    }

    public static void main(String[] args) {
        StackUsingTwoQueues stack = new StackUsingTwoQueues();

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
