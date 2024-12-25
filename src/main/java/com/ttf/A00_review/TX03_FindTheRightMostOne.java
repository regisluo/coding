package com.ttf.A00_review;

public class TX03_FindTheRightMostOne {
    public static int findRightMostOne(int a) {
        //a=00110101
        //-a=~a+1 = 11001010+1=11001011
        //00110101 &
        //11001011
        return a & (-a);
    }

    public static void printIntBits(int a) {
        for (int i = 31; i >= 0; i--) {
            System.out.print(((1 << i) & a) == 0 ? "0" : "1");
        }
    }

    public static void main(String[] args) {
        /*int a=4039259;
        printIntBits(a);
        System.out.println();
        printIntBits(findRightMostOne(a));*/
        int a = 1<<1;
        printIntBits(a);
    }
}
