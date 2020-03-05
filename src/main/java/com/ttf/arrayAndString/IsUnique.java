package com.ttf.arrayAndString;

/**
 * assume ASCII encoding string
 */
public class IsUnique {
    private static boolean isUnique(String s){
        if (s.length()>128)
            return false;
        // get char array of the given string
        char[] chars = s.toCharArray();
        int[] charInt = new int[128];
        for (char c:chars){
            if (charInt[c]==0)
                charInt[c] = 1;
            else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        String s1 = "falutioej";
        String s2="adfjldIf";

        System.out.println(isUnique(s1));
        System.out.println(isUnique(s2));
    }
}
