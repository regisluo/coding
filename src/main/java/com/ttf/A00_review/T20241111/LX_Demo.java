package com.ttf.A00_review.T20241111;

public class LX_Demo {
    private static Integer maxSumKArray(int[] arr, int k){
        if(arr==null || arr.length<k) {
            return null;
        }
        int L=0,R=k-1;
        int max = 0;
        // O(k)
        for(int i=0;i<k;i++){
            max+=arr[i]; // get the sum of the first window
        }
        int sum = max;
        //O(N-k)
        while(R+1<arr.length) {
            sum = sum + arr[++R] - arr[L++];
            System.out.println("L="+L+", R="+R+", sum="+sum);
            if (max<sum) {
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr= new int[]{2 , 1 , 5 , 1 , 3 , 2};
        int k=3;
        int ans = maxSumKArray(arr, k);
        System.out.println(ans);
    }
}
