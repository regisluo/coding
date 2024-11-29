package com.ttf.A00_review.T20241127;

public class TX024_PrintPaperFold {
    // N is the number of folding times
    public void print(int N) {
        /**
         * some facts:
         * 1. the root is down
         * 2. all the head of left is down
         * 3. all the head of right is up
         *
         * So the print is in-order traversal of the BT.
         * N is actually the height of the tree.
         *
         * If using recursive, N is no change in all recursive call
         */
        process(N, 1, false);
    }

    public void process(int N, int level, boolean isUp) {
        if (level > N) {
            return;
        }
        process(N, level + 1, false);
        System.out.print(isUp ? "Up " : "Down ");
        process(N, level + 1, true);
    }

    public static void main(String[] args) {
        TX024_PrintPaperFold instance = new TX024_PrintPaperFold();
        instance.print(3);
    }

}
