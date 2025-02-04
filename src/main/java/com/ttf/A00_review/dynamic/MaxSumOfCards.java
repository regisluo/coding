package com.ttf.A00_review.dynamic;

import java.util.Arrays;

public class MaxSumOfCards {

    public static int maxSumOfCards1(int[] cards) {
        return Math.max(first(cards, 0, cards.length-1), second(cards, 0, cards.length-1));
    }

    private static int first(int[] cards, int L, int R) {
        if(L==R){
            return cards[L];
        }
        return Math.max(cards[L] + second(cards, L+1, R), cards[R] + second(cards, L, R-1));
    }

    private static int second(int[] cards, int L, int R) {
        if (L == R) {
            return 0;
        }
        return Math.min(first(cards, L+1, R), first(cards, L, R-1));
    }
    // 初始位置，目标位置，普遍位置

    public static int maxSumOfCards2(int[] cards) {
        int N = cards.length;
        int f[][] = new int[N][N];
        int g[][] = new int[N][N];
        for(int i=0;i<N;i++){
            f[i][i] = cards[i];
        }

        for(int col=1;col<N;col++){// starting from column 1
            int L = 0;
            int R = col;
            while(R<N){
                f[L][R] = Math.max(cards[L] + g[L+1][R], cards[R] + g[L][R-1]);
                g[L][R] = Math.min(f[L+1][R], f[L][R-1]);
                L++;
                R++;
            }
        }
        return Math.max(f[0][N-1], g[0][N-1]);
    }



    public static void main(String[] args) {
        int[] cards = {1, 100, 2,20,50,3};
        System.out.println(maxSumOfCards1(cards));
        System.out.println(maxSumOfCards2(cards));
    }
}
