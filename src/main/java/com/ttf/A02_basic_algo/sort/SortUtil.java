package com.ttf.A02_basic_algo.sort;

public class SortUtil {
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j]=temp;
    }
}
