package com.ttf.tixiban;

/**
 * Given an integer array nums and two integers lower and upper, return the number of range sums that lie in [lower, upper] inclusive.
 * <p>
 * Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j inclusive, where i <= j.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-2,5,-1], lower = -2, upper = 2
 * Output: 3
 * Explanation: The three ranges are: [0,0], [2,2], and [0,2] and their respective sums are: -2, -1, 2.
 * Example 2:
 * <p>
 * Input: nums = [0], lower = 0, upper = 0
 * Output: 1
 */
public class TX09_CountRangeSum {
    public static int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        long[] prefixSum = new long[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        return process(prefixSum, 0, prefixSum.length - 1, lower, upper);
    }

    public static int process(long[] sum, int L, int R, int lower, int upper) {
        if (L == R) {
            return isMatch(sum[L], lower, upper) ? 1 : 0;
        }
        int M = L + ((R - L) >> 1);
        return process(sum, L, M, lower, upper) + process(sum, M + 1, R, lower, upper)
                + merge(sum, L, M, R, lower, upper);
    }

    private static boolean isMatch(long num, int lower, int upper) {
        return num >= lower && num <= upper;
    }

    public static int merge(long[] arr, int L, int M, int R, int lower, int upper) {
        int ans = 0;
        int windowL = L;
        int windowR = L;
        // [windowL, windowR)
        for (int i = M + 1; i <= R; i++) {
            // find out a Window in LEFT that all sums in the Window lands in the Range [lower, upper], thus the
            // count is WindowR-WindowL

            long min = arr[i] - upper;
            long max = arr[i] - lower;

            while (windowL <= M && arr[windowL] < min) {
                windowL++;
            }

            while (windowR <= M && arr[windowR] <= max) {
                windowR++;
            }

            ans += windowR - windowL;
        }

        // base MergeSort logic: compare and copy
        long[] help = new long[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        TX09_CountRangeSum solution = new TX09_CountRangeSum();
        int[] nums = {-2, 5, -1};
        int lower = -2, upper = 2;
        //Number of range sums within [-2, 2]: 3
        System.out.println("Number of range sums within [" + lower + ", " + upper + "]: "
                + solution.countRangeSum(nums, lower, upper));
    }
}
