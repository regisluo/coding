package com.ttf.basic_ds.queue;

/**
 * queue implementation based on DeQueue
 */
public class QueueUsingDeque<T> {
    DeQueue<T> deQueue;

    public QueueUsingDeque() {
        this.deQueue = new DeQueue<T>();
    }

    public boolean isEmpty(){
        return this.deQueue.isEmpty();
    }

    public T pop(){
        return this.deQueue.popHead();
    }

    public void push(T t){
        this.deQueue.addFromTail(t);
    }

    public int size() {
        return this.deQueue.size();
    }
}
