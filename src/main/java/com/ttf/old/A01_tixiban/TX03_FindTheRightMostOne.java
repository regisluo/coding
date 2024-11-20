package com.ttf.old.A01_tixiban;

public class TX03_FindTheRightMostOne {
    public static int findRightMostOne(int a) {
        return a & (-a);
    }

    public static void printIntBits(int a) {
        for (int i = 31; i >= 0; i--) {
            System.out.print(((1 << i) & a) == 0 ? "0" : "1");
        }
    }

    public static void main(String[] args) {
        int a=4039259;
        printIntBits(a);
        System.out.println();
        printIntBits(findRightMostOne(a));
    }
}
