package com.ttf.basic_algo.sort;

public class QuickSort2 {
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Partition and get the range of pivot indices
            int[] pivotRange = partition(array, low, high);

            // Recursively sort elements before the pivot range
            quickSort(array, low, pivotRange[0] - 1);

            // Recursively sort elements after the pivot range
            quickSort(array, pivotRange[1] + 1, high);
        }
    }

    // Partition method returning the start and end index of the pivot range
    private static int[] partition(int[] array, int low, int high) {
        int pivot = array[high]; // Use the last element as the pivot
        int less = low;             // Pointer for smaller elements
        int i = low;             // Pointer for equal elements
        int more = high;            // Pointer for larger elements

        while (i <= more) {
            if (array[i] < pivot) {
                // Swap elements smaller than the pivot to the front
                if (i>less) swap(array, less, i);
                less++;
                i++;
            } else if (array[i] > pivot) {
                // Swap elements greater than the pivot to the end
                swap(array, i, more);
                more--;
            } else {
                // Move the pointer for equal elements
                i++;
            }
        }

        // less is the starting index of pivot elements, and more is the ending index
        return new int[] {less, more};
    }

    // Swap utility method
    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        int[] numbers = {4, 2, 4, 4, 1, 3, 4, 6, 5};

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
