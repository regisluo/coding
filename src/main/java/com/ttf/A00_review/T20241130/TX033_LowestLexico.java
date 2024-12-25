package com.ttf.A00_review.T20241130;

import java.util.Arrays;
import java.util.Comparator;

public class TX033_LowestLexico {
    /**
     * 返回字符串数组中，所有的字符串拼接后按字母序排列的最小串
     */

    public String lowestLexico(String[] arr) {
        if (arr == null) {
            return null;
        }
        StringCombinComparator c = new StringCombinComparator();
        Arrays.sort(arr, c);
        String ans = "";
        for (String s : arr) {
            ans += s;
        }
        return ans;
    }

    private class StringCombinComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return (o1 + o2).compareTo(o2 + o1);
        }
    }
}
