package com.ttf.A00_review;

public class TX02_FindTheOnlyNumberOddTimes {
    public static int findOddNumber(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans ^= arr[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,1,3,3,4,5,5,6,6,7,7,8,8};
        System.out.println(findOddNumber(arr));
    }
}
