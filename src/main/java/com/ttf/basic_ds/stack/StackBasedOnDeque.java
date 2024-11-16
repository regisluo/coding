package com.ttf.basic_ds.stack;

import com.ttf.basic_ds.queue.DeQueue;

/**
 * Stack implementation based on DeQueue
 * @param <T>
 */
public class StackBasedOnDeque<T> {
    private DeQueue<T> deQueue;

    public StackBasedOnDeque() {
        this.deQueue = new DeQueue<T>();
    }

    public boolean isEmpty(){
        return this.deQueue.isEmpty();
    }

    public T pop() {
        return this.deQueue.popHead();
    }

    /**
     * big O(1)
     * @param t
     */
    public void push(T t){
        this.deQueue.addFromHead(t);
    }

    public int size() {
        return this.deQueue.size();
    }
}
