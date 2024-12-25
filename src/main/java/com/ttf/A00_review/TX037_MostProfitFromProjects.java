package com.ttf.A00_review;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * For a given Project array with cost and profit of each of the projects,
 * and a budget W and maximum number K of projects allowed to pick.
 * we need to find the maximum profit that can be achieved by selecting the projects from the given array.
 *
 * We can expecte that different W and K will produce different results.
 *
 * Example 1:
 * Input:
 */
public class TX037_MostProfitFromProjects {
    private class Project {
        int cost;
        int profit;

        // construct
        public Project(int cost, int profit) {
            this.cost = cost;
            this.profit = profit;
        }
    }

    /**
     * Find the maximum profit that can be achieved by selecting the projects from the given array.
     * @param projects: the given Project array
     * @param W: the budget
     * @param K: the maximum number of projects allowed to pick
     * @return the maximum profit
     *
     * 动态规划解法
     */
    private int mostProfit(Project[] projects, int W, int K) {
        // sort the projects by cost
        Arrays.sort(projects, (a, b) -> a.cost - b.cost);

        // dp[i][j] means the maximum profit we can get by selecting j project from the first i projects
        int[][] dp = new int[projects.length + 1][K + 1];

        for (int i = 1; i <= projects.length; i++) {
            for (int j = 1; j <= K; j++) {
                if (projects[i - 1].cost > W) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + projects[i - 1].profit);
                }
            }
        }

        return dp[projects.length][K];
    }

    private int maxProfit2(int[] cost, int[] profit, int W, int K) {
        // min heap per cost
        PriorityQueue<Project> perCost = new PriorityQueue<>((a, b) -> a.cost - b.cost);

        // max heap per profit
        PriorityQueue<Project> perProfit = new PriorityQueue<>((a, b) -> b.profit - a.profit);

        // put all the projects into min heap
        for (int i = 0; i < cost.length; i++) {
            perCost.offer(new Project(cost[i], profit[i]));
        }

        // select the projects from min heap and put them into max heap per the given budget
        for (int i = 0; i < K; i++) {
            while (!perCost.isEmpty() && perCost.peek().cost <= W) {
                // put all the projects that cost less than W into max heap
                perProfit.offer(perCost.poll());
            }
            if (perProfit.isEmpty()) {
                break;
            }
            // take the project with the maximum profit out of the max heap and add the profit to W
            Project project = perProfit.poll();
            System.out.println("project.cost: " + project.cost + ", project.profit: " + project.profit);
            W += project.profit;
        }
        return W;
    }

    public static void main(String[] args) {
        // test case using maxProfit2
        int[] cost = {0, 1, 2, 3};
        int[] profit = {1, 2, 3, 4};
        int W = 3;
        int K = 2;
        TX037_MostProfitFromProjects solution = new TX037_MostProfitFromProjects();
        System.out.println(solution.maxProfit2(cost, profit, W, K));
    }
}
