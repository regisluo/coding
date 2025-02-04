package com.ttf.A00_review.dynamic;

public class RobotWalk {

    /**
     * 机器人从start位置走steps步到达target位置的方法数
     * @param positions: 位置数
     * @param start: 起始位置
     * @param target: target position
     * @param steps: 步数
     * @return 方法数
     */
    public static int numberOfWays(int positions, int start, int target, int steps) {
        if (positions <= 0 || start < 0 || target < 0 || steps < 0 || (steps<Math.abs(target-start))) {
            return 0;
        }
        return process1(start, steps, target, positions);
    }
    public static int process1(int cur, int rest, int target, int positions) {
        if (rest == 0) {
            return cur == target ? 1 : 0;
        }
        if (cur == 1) {
            return process1(2, rest - 1, target, positions);
        }
        if (cur == positions) {
            return process1(positions - 1, rest - 1, target, positions);
        }
        return process1(cur - 1, rest - 1, target, positions) + process1(cur + 1, rest - 1, target, positions);
    }

    public static int numberOfWays2(int positions, int start, int target, int steps) {
        if (positions <= 0 || start < 0 || target < 0 || steps < 0 || (steps<Math.abs(target-start))) {
            return 0;
        }
        int[][] dp = new int[positions+1][steps+1];
        for (int i=0;i<positions+1;i++){
            for (int j=0;j<steps+1;j++){
                dp[i][j] = -1;
            }
        }

        return process2(start, steps, target, positions, dp);
    }

    /**
     *
     * 从顶向下的动态规划： 记忆化 搜索
     * 找到能决定返回值的参数，这里就是cur和rest，因为每次递归调用的时候，target和positions都不变
     */
    private static int process2(int cur, int rest, int target, int positions, int[][] dp) {
        if (dp[cur][rest] != -1) {
            return dp[cur][rest];
        }
        int ans = -1;
        if(rest == 0){
            ans = cur == target? 1: 0;
        } else if (cur==1){
            ans = process2(2, rest-1, target, positions, dp);
        } else if (cur==positions) {
            ans = process2(positions-1, rest-1, target, positions, dp);
        } else {
            ans = process2(cur+1, rest-1, target, positions, dp) + process2(cur-1, rest-1, target, positions, dp);
        }
        dp[cur][rest] = ans;
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(numberOfWays(5, 2, 4, 4));
        System.out.println(numberOfWays2(5, 2, 4, 4));
    }
}
