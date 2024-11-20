package com.ttf.A02_basic_algo.sort;

import java.util.Arrays;

public class RadixSort {

    // Main Radix Sort method
    public static void radixSort(int[] arr) {
        // Find the maximum number to know the number of digits
        int max = getMax(arr);

        // Perform counting sort for each digit, starting with the least significant digit
        int exp = 1; // Exponent represents the current digit position (1 for units, 10 for tens, etc.)
        while (max / exp > 0) {
            countingSortByDigit(arr, exp);
            exp *= 10;
        }
    }

    // Helper method to get the maximum value in the array
    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // Counting Sort based on a specific digit (exp represents the current digit place)
    private static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; // Output array to store sorted numbers
        int[] count = new int[10]; // Counting array for digits (0-9)

        // Count occurrences of each digit at the current position
        for (int num : arr) {
            int digit = (num / exp) % 10;
            count[digit]++;
        }

        // Update count[i] to store the position of the next element
        for (int i = 1; i < 10; i++) {
            // update to prefix sum
            count[i] += count[i - 1];
        }

        // Build the output array by looping the original array from right to left
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copy the sorted elements back into the original array
        System.arraycopy(output, 0, arr, 0, n);
    }

    // Test the algorithm
    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("Before Sorting: " + Arrays.toString(arr));

        radixSort(arr);

        System.out.println("After Sorting: " + Arrays.toString(arr));
    }
}

