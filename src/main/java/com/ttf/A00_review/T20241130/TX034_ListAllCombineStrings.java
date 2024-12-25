package com.ttf.A00_review.T20241130;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TX034_ListAllCombineStrings {
    /**
     * 给定一个字符串数组，列举出所有可能的字符串拼接结果.
     * You should use all the sub-strings in the String array.
     *
     * @return a list of string in which each element is a
     * string combination of the given string arr
     */
    public List<String> listAllCombines(List<String> arr) {
        if (arr == null || arr.size() == 1) {
            return arr;
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            for (String s : listAllCombines(removeIndex(arr, i))) {
                ans.add(arr.get(i) + s);
            }
        }
        return ans;
    }

    /**
     * remove the element at index i for given origin array.
     *
     * @return the sub-array removing the element at index i
     */
    private List<String> removeIndex(List<String> origin, int i) {
        List<String> ans = new ArrayList<>();
        for (int j = 0; j < origin.size(); j++) {
            if (j != i) {
                ans.add(origin.get(j));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TX034_ListAllCombineStrings ins = new TX034_ListAllCombineStrings();
        String[] origin = new String[]{"-a-", "-b-", "-c-",};
        List<String> ans = ins.listAllCombines(Arrays.asList(origin));
        for (String a : ans) {
            System.out.println(a);
        }
    }
}
