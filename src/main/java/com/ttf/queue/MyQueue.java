package com.ttf.queue;

public class MyQueue<E> {
    private Object arr[];
    private int head;
    private int tail;
    private final int length;
    private int size;

    public MyQueue(int length) {
        this.arr = new Object[length];
        this.head = 0;
        this.tail = 0;
        this.length = length;
        this.size = 0;
    }

    public E push(E e) {
        if (size == length) {
            throw new RuntimeException("Queue is full");
        }
        // there is space to add new element
        // move tail to next index
        arr[tail] = e;
        // tail move to next index (ring queue)
        tail = (tail + 1) % length;
        size++;
        return e;
    }

    // return and remove head element
    public E pop() {
        if (size == 0) {
            throw new RuntimeException("Queue is empty");
        }

        Object e = arr[head];
        //
        head = (head + 1) % length;
        size--;

        return (E) e;
    }

    // return head element
    public E peek() {
        if (size == 0) {
            throw new RuntimeException("Queue is empty");
        }

        Object e = arr[head];

        return (E) e;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args){
        MyQueue<Integer> myQueue = new MyQueue<Integer>(5);
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
//        myQueue.push(5);

        System.out.println(myQueue.isEmpty());

        System.out.println(myQueue.peek());

        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());

        // exception
        System.out.println(myQueue.pop());


    }

}
