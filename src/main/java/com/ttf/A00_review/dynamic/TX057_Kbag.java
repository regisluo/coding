package com.ttf.A00_review.dynamic;

/**
 * 背包问题：一个w数组，表示重量；一个v数组，表示价值；一个bag表示书包能装的最大重量。
 * 返回：不超过背包重量的最大价值的货物组合。
 */
public class TX057_Kbag {

    public static int getMaxValueForBag(int bag, int[] w, int v[]) {
        if (w==null || v==null || w.length != v.length || w.length == 0) {
            return 0;
        }
        return maxValue(bag, w, v, 0);
    }

    // 开始考虑index的货物。返回index开始的货物的最大价值
    public static int maxValue(int bag, int[] w, int v[], int index) {
        // base case: 与入参有关, 与变化参数有关
        if (index == w.length) {
            return 0;
        }
        // bag的重量会变化
        if (bag<0) {
            return 0;
        }

        // choose index
        int p1 = 0;
        if (w[index]<=bag) // only when the w[index] <= bag, can choose
          p1 = v[index] + maxValue(bag-w[index], w, v, index+1);

        // not choose index
        int p2 = maxValue(bag, w, v, index+1);

        return Math.max(p1, p2);
    }

    /**
     * 暴力递归改动态规划：
     * dp表是啥？就是能保存所有可能“暴力递归返回值”的一个数据结构，i.e 一维数组，二维数组等
     * 目的是填充dp表。怎么填？从base case入手，然后通过递归函数，分析依赖，比如index依赖index+1。
     * 而且很多时候，尝试写对了，改动态规划与原题都没关系了。
     * 一般而言，尝试策略本身，就是动态规划转移方程。
     * 可以画图，比如一维数组或二维数组，分析填充过程，找出规律。
     */
    public static int maxValue2(int bag, int[] w, int v[], int index) {
        int N = w.length;

        int[][] dp = new int[N+1][bag+1];

        // populate dp
        for(int ind=N-1;ind>=0;ind--) {
            for(int rest=0;rest<=bag;rest++) {
                int p1=0;
                if (w[ind]<=rest) { // can choose this item
                    p1 = v[ind] + dp[ind+1][rest-w[ind]];
                }
                // not choose this item
                int p2 = dp[ind+1][rest];
                dp[ind][rest] = Math.max(p1, p2);
            }
        }

        return dp[0][bag];
    }

    public static void main(String[] args) {
        int[] w = {3,2,4,7,3,1,7};
        int[] v = {5,6,3,19,12,4,2};
        int bag=15;
        System.out.println(maxValue(bag,w,v,0));
        System.out.println(maxValue2(bag, w,v,0));
    }
}
