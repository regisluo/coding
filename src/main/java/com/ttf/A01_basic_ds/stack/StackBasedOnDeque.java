package com.ttf.A01_basic_ds.stack;

import com.ttf.A01_basic_ds.queue.DeQueue;

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
        //出也是从队头出
        return this.deQueue.popHead();
    }

    /**
     * big O(1)
     * @param t
     */
    public void push(T t){
        //可以理解为插队：每次进都排在队头
        this.deQueue.addFromHead(t);
    }

    public int size() {
        return this.deQueue.size();
    }
}
