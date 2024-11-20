package com.ttf.A02_basic_algo.sort;

/**
 * 计数排序（Counting Sort）是一种线性时间复杂度的排序算法，适用于已知整数值范围的数组.
 * 假定最大值是maxValue
 */
public class CountingSort {

    private static void countingSort(int[] arr, int maxValue) {
        // prepare an array to store the count of each number
        int[] count = new int[maxValue+1];
        // get the count of each number
        for (int i:arr) {
            count[i]++;
        }
        int index=0;
        // update the original array using count array
        for(int i=0;i<=maxValue;i++) {
            while (count[i]>0) {
                // populate the number of i
                arr[index++] = i;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,4,5,2,2,12,33,45,6,78,45,65,90,5};
        int max = 0;
        for(int num:arr){
            if (num>max)
                max = num;
        }
        System.out.println("Max="+max);
        countingSort(arr, max);
        for (int i:arr){
            System.out.print(i+", ");
        }
    }
}
