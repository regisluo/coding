package com.ttf.old.A01_tixiban.TX04_StackAndQueue;

/**
 * An implementation of queue using array
 */
public class CircularQueue {
    int[] data;
    int front;
    int rear;
    int capacity;
    int size;

    public CircularQueue(int capacity) {
        this.data = new int[capacity];
        this.capacity = capacity;
        front = 0;
        rear = 0;
        size = 0;
    }

    private boolean isFull() {
        return this.size == this.capacity;
    }

    private boolean isEmpty() {
        return this.size == 0;
    }

    private void enqueue(int n) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        this.data[rear] = n;
        rear = (rear + 1) % this.capacity;
        this.size++;
    }

    private int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int ans = this.data[front];
        front = (front + 1) % this.capacity;
        this.size--;
        return ans;
    }

    private int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return this.data[front];
    }

    private int getSize() {
        return this.size;
    }

    // Print the queue (for debugging)
    public void printQueue() {
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(data[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);

        // Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        // Print the queue
        queue.printQueue();  // Output: Queue: 10 20 30 40

        // Dequeue elements
        System.out.println("Dequeued: " + queue.dequeue());  // Output: Dequeued: 10
        queue.printQueue();  // Output: Queue: 20 30 40

        // Peek the front element
        System.out.println("Front element: " + queue.peek());  // Output: Front element: 20

        // Add more elements
        queue.enqueue(50);
        queue.enqueue(60);
        queue.printQueue();  // Output: Queue: 20 30 40 50 60

        // Try to enqueue when the queue is full
        queue.enqueue(70);  // Output: Queue is full
    }
}
