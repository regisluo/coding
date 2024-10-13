package com.ttf.tx.TX04_StackAndQueue.StackUsingQueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueues {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public StackUsingTwoQueues(){
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // time complexity is O(n)
    // require extra space
    private void push(int data){
        if (!q1.isEmpty()){
            q2.offer(q1.poll());
        }

        q1.offer(data);

        if (!q2.isEmpty()){
            q1.offer(q2.poll());
        }
    }

    // O(1)
    private int pop(){
        if (q1.isEmpty()){
            // throw
        }
        return q1.poll();
    }
}
