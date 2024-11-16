package com.ttf.basic_ds.stack;


import com.ttf.basic_ds.queue.QueueUsingArray;

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

    public Integer pop() throws Exception {
        // move elements(except the tail) from dataQueue to helpQueue
        while (dataQueue.size() > 1) {
            helpQueue.enque(dataQueue.deque());
        }

        Integer ans = dataQueue.deque();
        //swap reference of dataQueue and helpQueue
        QueueUsingArray tmp = dataQueue;
        dataQueue = helpQueue;
        helpQueue = tmp;

        return ans;
    }

    public boolean isEmpty() {
        return dataQueue.isEmpty();
    }

    public Integer peek() throws Exception {
        // move elements(except the tail) from dataQueue to helpQueue
        while (dataQueue.size() > 1) {
            helpQueue.enque(dataQueue.deque());
        }

        Integer ans = dataQueue.deque();
        // add the tail to help
        helpQueue.enque(ans);

        //swap reference of dataQueue and helpQueue
        QueueUsingArray tmp = dataQueue;
        dataQueue = helpQueue;
        helpQueue = tmp;

        return ans;
    }
}
