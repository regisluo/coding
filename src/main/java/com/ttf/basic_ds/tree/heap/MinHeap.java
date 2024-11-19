package com.ttf.basic_ds.tree.heap;
import static com.ttf.Util.swap;

public class MinHeap {
    private int[] arr;
    private int capacity;
    private int size;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.arr = new int[capacity];
    }

    public int size() {
        return this.size;
    }

    public boolean empty() {
        return this.size == 0;
    }

    public int parent(int index) {
        return (index - 1) / 2;
    }

    public int left(int index) {
        return 2 * index + 1;
    }

    public int right(int index) {
        return 2 * index + 2;
    }

    public void add(int number) throws Exception {
        if (this.size == this.capacity) {
            throw new Exception("the heap is full");
        }
        this.arr[size] = number;
        size++;
        int current = this.size - 1;
        // bubbling up to fix the heap property: compare the element with parent
        while (arr[current] < arr[parent(current)]) {
            swap(arr, current, parent(current));
            current = parent(current);
        }
    }

    public int remove() throws Exception {
        if (this.size == 0) {
            throw new Exception("the heap is empty");
        }
        int ans = this.arr[0];

        swap(arr, 0, this.size - 1);
        this.size--;
        heapify(0);

        return ans;
    }

    // bubbling down the element at given index to fix the heap property
    private void heapify(int index) {
        // compare the current with left and right
        int left = left(index);
        while (left < this.size) {
            int right = right(index);
            int smallest = index;
            // find the smallest index with the 'smallest' value
            if (arr[left] < arr[smallest]) {
                smallest = left;
            }

            if (right < size && arr[right] < arr[smallest]) {
                smallest = right;
            }

            if (smallest != index) {
                swap(arr, smallest, index);
            }
            index = smallest;
            left = left(index);
        }
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        MinHeap minHeap = new MinHeap(10);

        minHeap.add(10);
        minHeap.add(5);
        minHeap.add(3);
        minHeap.add(7);

        System.out.println("Heap after adding elements:");
        minHeap.printHeap(); // Should print: 3 7 5 10

        System.out.println("Removed: " + minHeap.remove()); // Should print: 3
        System.out.println("Heap after removing the smallest element:");
        minHeap.printHeap(); // Should print: 5 7 10
    }
}
