package com.ttf.A00_review.greddy;

import java.util.ArrayList;
import java.util.List;

public class TX051_AllSubStringOfString {
    public List<String> allSubStringOfString(String input) {
        /**
         * here, if using a List may have duplicate;
         * change to Set to maintain unique
         */
        List<String> result = new ArrayList<>();
        char[] inputChars = input.toCharArray();
        String path= "";
        generateSubstrings(inputChars, 0, path, result);
        return result;
    }

    // Recursive helper method
    private static void generateSubstrings(char[] chars, int index, String path, List<String> result) {
        if(index==chars.length) {
            result.add(path);
            return;
        }

        // Case 1: Include the current character
        generateSubstrings(chars, index+1, path+chars[index], result);

        // Case 2: Exclude the current character
        generateSubstrings(chars, index+1, path, result);
    }

    public static void main(String[] args) {
        TX051_AllSubStringOfString allSubStringOfString = new TX051_AllSubStringOfString();
        List<String> answer = allSubStringOfString.allSubStringOfString("aaa");
        for (String str : answer) {
            System.out.println(str);
        }
    }
}
