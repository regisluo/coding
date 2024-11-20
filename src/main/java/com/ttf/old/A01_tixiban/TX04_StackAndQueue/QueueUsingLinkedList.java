package com.ttf.old.A01_tixiban.TX04_StackAndQueue;

public class QueueUsingLinkedList<T>{
    Node<T> head;
    Node<T> tail;
    int size;

    public QueueUsingLinkedList(){
        this.size=0;
        this.head=null;
        this.tail=null;
    }

    public void enQueue(T data) {
        // create a node
        Node newNode = new Node(data);
        if (isEmpty()){
            head=tail=newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size ++;
    }

    public T deQueue() {
        if (isEmpty()){
            System.out.println("Queue is empty");
        }
        T data = head.data;
        head = head.next;
        if (head==null){// only one or the last node
            tail = null;
        } else {
            head.prev = null;
        }
        size --;
        return data;
    }

    public T peek(){
        if (isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        return head.data;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    private int getSize(){
        return this.size;
    }
}
