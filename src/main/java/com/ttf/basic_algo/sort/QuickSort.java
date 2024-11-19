package com.ttf.basic_algo.sort;

public class QuickSort {
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(array, low, high);

            // Recursively sort elements before and after the pivot
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    // Partition method
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high]; // Choose the last element as pivot
        int i = low;         // Pointer for the smaller element

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                if (j>i){
                    // Swap array[i] and array[j]
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
                i++;
            }
        }

        // Swap the pivot element with the element at i
        int temp = array[i];
        array[i] = array[high];
        array[high] = temp;

        return i; // Return the pivot index
    }

    public static void main(String[] args) {
        int[] numbers = {10, 7, 8, 9, 1, 5};

        System.out.println("Before sorting:");
        printArray(numbers);

        quickSort(numbers, 0, numbers.length - 1);

        System.out.println("After sorting:");
        printArray(numbers);
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
