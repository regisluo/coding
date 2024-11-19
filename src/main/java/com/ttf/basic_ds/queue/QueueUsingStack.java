package com.ttf.basic_ds.queue;


import com.ttf.basic_ds.stack.StackUsingArray;

public class QueueUsingStack {
    int length;
    // add new element into the stack
    private StackUsingArray pushStack;

    // return head of the stack
    private StackUsingArray popStack;

    public QueueUsingStack(int length){
        this.length = length;
        pushStack = new StackUsingArray(this.length);
        popStack = new StackUsingArray(this.length);
    }

    public void move(){
        if(popStack.empty()){
            // only when popStack is empty, move all elements from pushStack to popStack
            while (!pushStack.empty())
                popStack.push(pushStack.pop());
        }
    }

    public void push(int e){
        pushStack.push(e);
        move();
    }

    public Integer pop(){
        if (isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        move();
        return popStack.pop();
    }

    public boolean isEmpty(){
        return popStack.empty() && pushStack.empty();
    }

    public Integer peek(){
        if (isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        move();
        return popStack.peek();
    }


}
