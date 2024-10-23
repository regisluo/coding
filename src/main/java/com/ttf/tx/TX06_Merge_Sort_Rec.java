package com.ttf.tx;

import java.util.Arrays;

public class TX06_Merge_Sort_Rec {

    public static void mergeSort_rec(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int m = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, m);
        int[] right = Arrays.copyOfRange(arr, m, arr.length);
        mergeSort_rec(left);
        mergeSort_rec(right);
        merge(arr, left, right);
    }


    // both right and right are already sorted
    // need to merge the left and right to the arr
    public static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    public static void mergeSort_rec2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 卡下标
        process(arr, 0, arr.length - 1);

    }

    public static void process(int[] arr, int left, int right) {
        // base case
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);

        process(arr, left, mid);
        process(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    /**
     * merge sub array: left->mid, mid+1->right
     */
    public static void merge(int[] arr, int left, int mid, int right) {
        int p1 = left;
        int p2 = mid + 1;
        int i = 0;
        int[] help = new int[right - left + 1];

        while (p1 <= mid && p2 <= right) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }
        for (int k = 0; k < help.length; k++) {
            arr[left + k] = help[k];
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 4, 6, 2, 3};
        System.out.println("Original Array: " + Arrays.toString(array));

        mergeSort_rec2(array);

        System.out.println("Sorted Array (Recursive): " + Arrays.toString(array));
    }
}
