package com.ttf.tx.TX04_StackAndQueue.StackUsingQueue;

import com.ttf.tx.TX04_StackAndQueue.QueueUsingLinkedList;

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
        queue.offer(data);

        // rotate the queue so the last element is at the front
        int size = queue.size();

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

}
