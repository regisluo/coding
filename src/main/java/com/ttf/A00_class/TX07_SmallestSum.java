package com.ttf.A00_class;
public class TX07_SmallestSum {

    public static int smallestSum(int[] arr) {
        if (arr==null || arr.length<2){
            return 0;
        }
        return process(arr, 0, arr.length-1);
    }

    public static int process(int[] arr, int left, int right) {
        if (left==right) {
            return 0;
        }
        int mid = left +((right-left)>>1);
        return process(arr, left, mid) + process(arr, mid+1, right)+merge(arr, left, mid, right);
    }

    public static int merge(int[] arr, int left, int mid, int right) {
        int sum = 0;
        int p1 = left;
        int p2 = mid + 1;
        int i = 0;
        int[] help = new int[right - left + 1];

        while (p1 <= mid && p2 <= right) {
            if (arr[p1] < arr[p2]) {// the left should be strictly smaller than right.
                sum += arr[p1] * (right-p2+1); // the number arr[p1] contributes (right-p2+1) times value to the sum
                help[i++] =  arr[p1++];
            } else {// include equal, which means need to copy right first
                help[i++] = arr[p2++];
            }
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
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,1,3,0,6,3,9};
        System.out.println(TX07_SmallestSum.smallestSum(arr));
    }
}
