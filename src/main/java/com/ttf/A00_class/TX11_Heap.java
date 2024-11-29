package com.ttf.A00_class;

import com.ttf.Util;

import java.util.Arrays;

public class TX11_Heap {
    int length;
    int[] arr;
    int size;
    double ratio = 0.75;

    public TX11_Heap(int limit){
        this.arr = new int[limit];
        this.length = limit;
        this.size=0;
    }


    // check arr[i] with its children, to make sure it is a heap
    // size is the heap size
    private void poll(int[] arr, int i, int size) {
        int left = 2 * i + 1;
        while (left < size) {
            int biggest = (left + 1) < size && arr[left] > arr[left + 1] ? left : left + 1;
            if (arr[i] >= arr[biggest]) {
                break;
            }
            Util.swap(arr, i, biggest);
            i = biggest;
            left = 2 * i + 1;
        }
    }

    // insert a number into the heap
    private void add(int number) {
        if (this.size > this.length*this.ratio) {
            // extend the array
            this.arr  = Arrays.copyOf(this.arr, this.length*2);
        }
        heapInsert(arr, number);
    }

    private void heapInsert(int[] arr, int number){
        this.arr[this.size] = number;
        size++;
        int currentIndex = size-1;
        // refactor to heap: 0~size-1
        while (arr[currentIndex]>arr[(currentIndex-1)/2]) {
            Util.swap(arr, currentIndex, (currentIndex-1)/2);
            currentIndex = (currentIndex-1)/2;
        }
    }

    private int poll(){
        // record the top number first and return lastly as the answer
        int ans = this.arr[0];
        // swap the top number with the last one
        Util.swap(arr, 0, --this.size);
        heapify(arr, size, 0);
        return ans;
    }

    private void heapify(int[] arr, int size, int parent) {
        int left = 2*parent+1;
        while (left < size) {
            // compare the value of left and right
            int bigger = (left + 1) < size && arr[left] > arr[left + 1] ? left : left + 1;
            // compare the value between the 'bigger' and its parent
            if (arr[parent] >= arr[bigger]) {// the parent value already the bigger one, so stop
                break;
            }
            Util.swap(arr, parent, bigger);
            parent = bigger;// heapify: parent index down to 'bigger' child
            left = 2 * parent + 1;
        }
    }

    private void refactor() {
        int n=this.poll();
        this.add(n);
    }

    // update the value to the given for index
    private void update(int index, int value) {
        this.arr[index]=value;
    }

    public static void main(String[] args) {
        TX11_Heap heap = new TX11_Heap(10);
        heap.add(3);
        heap.add(5);
        heap.add(2);
        System.out.println(heap.poll());

        heap.add(6);
        heap.add(1);
        heap.add(4);

        //System.out.println(heap.poll());

        /**
         *              6
         *            4   3
         *          1   2
         *
         *    this is the array representation: [6,4,3,1,2]
         */
        // how if we change number 4 to 7 which breaks the heap structure
        // then call refactor method
        heap.update(1, 7);
        System.out.println("After change the arr:");
        for (int i=0;i< heap.size;i++){
            System.out.print(heap.arr[i]+" ");
        }

        System.out.println("\nAfter refactor to heap again:");
        heap.refactor();
        for (int i=0;i< heap.size;i++){
            System.out.print(heap.arr[i]+" ");
        }
    }



}
