package com.ttf.A01_basic_ds.stack;


import com.ttf.A01_basic_ds.queue.QueueUsingArray;

public class StackUsingQueue {
    private QueueUsingArray dataQueue;
    private QueueUsingArray helpQueue;

    public StackUsingQueue() {
        dataQueue = new QueueUsingArray(5);
        helpQueue = new QueueUsingArray(5);
    }

    public void push(Integer e) throws Exception {
        dataQueue.enque(e);
    }

    private void move() throws Exception {
        // move elements(except the tail) from dataQueue to helpQueue
        while (dataQueue.size() > 1) {
            helpQueue.enque(dataQueue.deque());
        }
    }
    private void swap() {
        QueueUsingArray tmp = dataQueue;
        dataQueue = helpQueue;
        helpQueue = tmp;
    }
    public Integer pop() throws Exception {
        move();
        Integer ans = dataQueue.deque();
        //swap reference of dataQueue and helpQueue
        swap();
        return ans;
    }

    public boolean isEmpty() {
        return dataQueue.isEmpty();
    }

    public Integer peek() throws Exception {
        move();
        int ans = dataQueue.deque();
        // add the tail to helpQueue
        helpQueue.enque(ans);
        //swap reference of dataQueue and helpQueue
        swap();
        return ans;
    }
}
