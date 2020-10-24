package com.ttf.queue;

public class QueueImplUsingArray {
    public static class RQueue{
        private int arr[];
        private int size;
        private final int length;
        private int head;
        private int tail;

        public RQueue(int length){
            arr = new int[length];
            this.size=0;
            this.length=length;
            this.head=0;
            this.tail=0;
        }

        public void inQueue(int value) throws Exception {
            if(size==arr.length){
                throw new Exception("Queue is full");
            }

            size++; // a new element is added into the queue
            arr[tail]=value;// add in the tail
            tail=getNextIndex(tail);

        }

        public int deQueue() throws Exception{
            if (size==0){
                throw new Exception("there is no element in the queue");
            }
            size--;
            int queueHead=arr[head];
            head=getNextIndex(head);
            return queueHead;

        }

        private int getNextIndex(int index) {
            return index+1>length?0:index+1;
        }

    }
}
