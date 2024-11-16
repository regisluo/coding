package com.ttf.old.xor;

public class Xor {
    public static void swapNoExtraNumber(int a, int b){
        a = a^b;
        b=a^b;//b change to a
        a=a^b;// a changed to b
    }

    // find out the number exist odd times in the given arr
    public static int findOutOddNumber(int[] arr){
        int eor = 0;
        for(int i=0;i<arr.length;i++){
            eor^=arr[i];
        }
        return eor;
    }

    public static int findOutTheRightMostOne(int n) {
        int i = 0;

        return i;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,2,3,4,4,5,1,6,6,7,7,8,8};
        System.out.println(findOutOddNumber(arr));
    }
}
