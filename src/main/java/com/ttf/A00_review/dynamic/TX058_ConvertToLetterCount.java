package com.ttf.A00_review.dynamic;

public class TX058_ConvertToLetterCount {

    // digits是0-9的数字；但是规定1对应A， 26对应Z，所以0不能单独对应字母，只能是10，20有意义
    public static int convertToLetterCount(String digits) {
        if (digits == null || digits.length() == 0) {
            return 0;
        }
        return process(digits.toCharArray(), 0);
    }

    /**
     * 暴力递归：返回从cur开始的子串，可以转换的方法数. digits[0...cur-1]不用管了
     */
    private static int process(char[] digits, int cur) {
        // base case
        if (cur == digits.length) {
            return 1;
        }
        int N = digits.length;

        if (digits[cur] == '0') {
            return 0;
        }

        int ways = process(digits, cur + 1);

        if (cur + 1 < N && ((digits[cur] - '0') * 10 + (digits[cur + 1] - '0') < 27)) {
            ways += process(digits, cur + 2);
        }
        return ways;
    }

    private static int dp(String s) {
        char[] digits = s.toCharArray();
        int N = digits.length;
        int[] dp = new int[N + 1];
        dp[N] = 1;
        for (int i = N - 1; i >= 0; i--) {
            if (digits[i] != '0') {
                dp[i] = dp[i + 1];
                if (i + 1 < N && ((digits[i] - '0') * 10 + (digits[i + 1] - '0') < 27)) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(convertToLetterCount("1114236546"));
        System.out.println(dp("1114236546"));
    }

}
