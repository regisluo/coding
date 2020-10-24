package com.ttf.stack;

import com.ttf.queue.MyQueue;

public class StackImplUsingQueue {
    private MyQueue<Integer> dataQueue;
    private MyQueue<Integer> helpQueue;

    public StackImplUsingQueue() {
        dataQueue = new MyQueue<Integer>(5);
        helpQueue = new MyQueue<Integer>(5);
    }

    public void push(Integer e) {
        dataQueue.add(e);
    }

    public Integer pop() {
        // move elements(except the tail) from dataQueue to helpQueue
        while (dataQueue.size() > 1) {
            helpQueue.add(dataQueue.poll());
        }

        Integer ans = dataQueue.poll();
        //swap reference of dataQueue and helpQueue
        MyQueue<Integer> tmp = dataQueue;
        dataQueue = helpQueue;
        helpQueue = tmp;

        return ans;
    }

    public boolean isEmpty() {
        return dataQueue.isEmpty();
    }

    public Integer peek() {
        // move elements(except the tail) from dataQueue to helpQueue
        while (dataQueue.size() > 1) {
            helpQueue.add(dataQueue.poll());
        }

        Integer ans = dataQueue.poll();
        // add the tail to help
        helpQueue.add(ans);

        //swap reference of dataQueue and helpQueue
        MyQueue<Integer> tmp = dataQueue;
        dataQueue = helpQueue;
        helpQueue = tmp;

        return ans;
    }
}
