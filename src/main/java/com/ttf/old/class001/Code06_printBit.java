package com.ttf.old.class001;

public class Code06_printBit {
    public static void printBit(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int num = 1;
        printBit(num);
        num = -1;
        printBit(num);
        num = 3;
        printBit(num);
        num = -3;
        printBit(num);

    }
}
