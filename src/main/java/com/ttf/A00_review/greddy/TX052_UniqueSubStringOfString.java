package com.ttf.A00_review.greddy;

import java.util.HashSet;
import java.util.Set;

public class TX052_UniqueSubStringOfString {
    public Set<String> allSubStringOfString(String input) {
        Set<String> result = new HashSet<>(); // using Set to remove duplication
        char[] inputChars = input.toCharArray();
        String path= "";
        generateSubstrings(inputChars, 0, path, result);
        return result;
    }

    // Recursive helper method
    private static void generateSubstrings(char[] chars, int index, String path, Set<String> result) {
        if(index==chars.length) {
            if (path.length() > 0)
                result.add(path);
            return;
        }

        // Case 1: Include the current character
        generateSubstrings(chars, index+1, path+chars[index], result);

        // Case 2: Exclude the current character
        generateSubstrings(chars, index+1, path, result);
    }

    public static void main(String[] args) {
        TX052_UniqueSubStringOfString allSubStringOfString = new TX052_UniqueSubStringOfString();
        Set<String> answer = allSubStringOfString.allSubStringOfString("aaa");
        for (String str : answer) {
            System.out.println(str);
        }
    }
}
