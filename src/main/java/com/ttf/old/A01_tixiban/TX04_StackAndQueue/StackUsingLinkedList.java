package com.ttf.old.A01_tixiban.TX04_StackAndQueue;

public class StackUsingLinkedList<T> {
    Node<T> top;
    int size;

    public StackUsingLinkedList(){
        this.top = null;
        this.size = 0;
    }

    public void push(T data){
        Node<T> node = new Node<>(data);
        if (top == null){
            top = node;
        } else {
            node.next = top;
            top.prev = node;
            top = node;
        }
        size ++;
    }

    public T peek(){
        if (isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }

    private T pop(){

        if (isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        T data = top.data;
        top = top.next;
        if (top!=null){
            top.prev = null;
        }
        size --;
        return data;
    }

    private boolean isEmpty(){
        return size == 0;
    }
}
