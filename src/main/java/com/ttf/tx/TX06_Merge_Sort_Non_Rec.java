package com.ttf.tx;

import java.util.Arrays;

// non-recursive
public class TX06_Merge_Sort_Non_Rec {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        for (int step = 1; step < n; step *= 2) {
            for (int leftStart = 0; leftStart < n; leftStart += 2 * step) {
                int mid = Math.min(leftStart + step - 1, n-1);
                int rightEnd = Math.min(leftStart + 2 * step - 1, n - 1);
                TX06_Merge_Sort_Rec.merge(arr, leftStart, mid, rightEnd);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Original Array: " + Arrays.toString(array));

        mergeSort(array);

        System.out.println("Sorted Array (Non-Recursive): " + Arrays.toString(array));
    }
}
