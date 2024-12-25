package com.ttf.A00_review;

public class TX01_SwapTwoNumbersNoExtraVar {
    //Swap two numbers without using extra variable?
    public static void swapWithoutExtra(int a, int b) {
        a = a ^ b;
        b = a ^ b; // a^b^b = a, because b^b = 0, and a^0 = a
        // on the right, a is a^b not change, but b is changed to a
        // thus a^b^a=b, as it is assignment operation, so a changed to b
        a = a ^ b;
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }

    public static void main(String[] args) {
        int a = 3;
        int b = 5;
        swapWithoutExtra(a, b);
    }
}
