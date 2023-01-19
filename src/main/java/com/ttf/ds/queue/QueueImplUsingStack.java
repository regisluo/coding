/*
package com.ttf.ds.queue;

import com.ttf.ds.stack.MyStack;

public class QueueImplUsingStack {
    // add new element into the queue
    private MyStack<Integer> stackPush;

    // return head of the queue
    private MyStack<Integer> stackPop;

    public QueueImplUsingStack(){
        stackPush = new MyStack<Integer>(5);
        stackPop = new MyStack<Integer>(5);
    }

    public void pushToPop(){
        if(stackPop.isEmpty()){// only when stopPop is empty
            // move all elements from add to poll stack
            while (!stackPush.isEmpty())
                stackPop.push(stackPush.pop());
        }
    }

    public void push(Integer e){
        stackPush.push(e);
        pushToPop();
    }

    public Integer pop(){
        if (isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        pushToPop();
        return stackPop.pop();
    }

    public boolean isEmpty(){
        return stackPop.isEmpty() && stackPush.isEmpty();
    }

    public Integer peek(){
        if (isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        pushToPop();
        return stackPop.peek();
    }


}
*/
