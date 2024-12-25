package com.ttf.A00_review;

public class LX_All {
    public static void main(String[] args) {
//       int a=3, b=5;
//        //swapTwoNumberNoVar(a,b);
//        int[] arr = new int[]{2,2,3,4,4,5,5,6,6,7,7,8,8,8,8};
//        System.out.println(findTheOnlyNumberOddTimes(arr));
        int a=42;
        System.out.println(String.format("%8s", Integer.toBinaryString(a))
                .replace(' ', '0'));
        System.out.println(findTheRightMostOne(a));
    }

    private static void swapTwoNumberNoVar(int a, int b) {
        System.out.println("before: a="+a+", b="+b);
        a = a^b;
        b=a^b; //a^b^b = a^0 = a; so now b changed to a
        a=a^b; // a^b^a = a^a^b = 0^b = b; so a changed to b
        System.out.println("after: a="+a+", b="+b);
    }

    private static int findTheOnlyNumberOddTimes(int[] arr) {
        int e=0;
        for (int i:arr){
            e ^= i;
        }
        return e;
    }


    // tx03
    private static String findTheRightMostOne(int a) {
        // for a given int number say 10001100100, return: 00000000100
        // solution is a&(-a)
        return String.format("%8s", Integer.toBinaryString(a&(-a)))
                .replace(' ', '0');
    }


}
