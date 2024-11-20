package com.ttf.old.A01_tixiban.TX04_StackAndQueue.TX05.StackUsingQueue;

import java.util.Stack;

public class QueueUsingTwoStacks {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public QueueUsingTwoStacks(){
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }

    private void enqueue(int data){
        s1.push(data);
    }

    private int dequeue(){
        // empty check
        // copy from s1 to s2 only when s2 is empty
        if (s2.isEmpty()){
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }
        return s2.pop();
    }

    // peek is same as dequeue

    private boolean isEmpty(){
        return s1.isEmpty() && s2.isEmpty();
    }
}
