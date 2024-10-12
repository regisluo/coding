package com.ttf.class001;

public class InsertSort {

    public static void insertSort(int[] arr) {
        //edge cases
        if (arr == null || arr.length <= 1) {
            return;
        }
        int N = arr.length;
        for (int end = 1; end < N; end++) {
            int curIndex = end;
            while (curIndex - 1 >= 0 && arr[curIndex] < arr[curIndex - 1]) {
                swap(arr, curIndex, curIndex - 1);
                curIndex--;
            }
        }
        print(arr);
    }


    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }
        System.out.println();
    }

    public static void swap(int arr[], int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        // int n = 10;
        // System.out.println(NJieChent(n));
        int[] arr = {3, 5, 6, 4, 6, 7, 9, 2, 4, 1};
        insertSort(arr);
    }
}
