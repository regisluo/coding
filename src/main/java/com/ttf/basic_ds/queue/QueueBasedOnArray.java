package com.ttf.basic_ds.queue;

/**
 * Queue implementation based on fix-length array
 */
public class QueueBasedOnArray {
    /**
     * the array to store the element
     */
    private int arr[];
    /**
     * the current number of element in the queue
     */
    private int size;
    /**
     * the max length of the queue
     */
    private final int length;

    private int head;
    private int tail;

    public QueueBasedOnArray(int length) {
        arr = new int[length];
        this.size = 0;
        this.length = length;
        this.head = 0;
        this.tail = 0;
    }

    public void push(int value) throws Exception {
        if (size == arr.length) {
            throw new Exception("Queue is full");
        }

        size++; // a new element is added into the queue
        arr[tail] = value;// add in the tail
        tail = getNextIndex(tail);

    }

    public int poll() throws Exception {
        if (size == 0) {
            throw new Exception("there is no element in the queue");
        }
        size--;
        int headValue = arr[head];
        head = getNextIndex(head);
        return headValue;

    }

    private int getNextIndex(int index) {
        return index < length - 1 ? index + 1 : 0;
    }
}
