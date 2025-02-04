package com.ttf.A00_review.greddy;

public class TX050_Han {
    public void printAllStepsOfHan(int n) {
        print("left", "right", "middle", n);
    }

    private void print(String from, String to, String other, int n) {
        if (n==1){
            System.out.println(String.format("%d: %s -> %s",n, from, to));
        } else {
            print(from,other, to, n-1);
            System.out.println(String.format("%d: %s -> %s", n, from, to));
            print(other, to, from, n-1);
        }
    }

    public static void main(String[] args) {
        int N=3;
        TX050_Han ins = new TX050_Han();
        ins.printAllStepsOfHan(N);
    }


}
