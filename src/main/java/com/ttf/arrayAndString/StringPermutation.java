package com.ttf.arrayAndString;

/**
 * given two strings, decide if one is a permutation of the other
 */
public class StringPermutation {
    /**
     * assumption:
     *  case sensitive
     *  spaces are important
     *  all characters in strings are ASCII encoded
     *
     */

  static boolean isPermutation(String s1, String s2){
        boolean isPermutation = true;
        //either s1 or s2 is null will return false
        if (s1==null || s2==null)
            isPermutation = false;
        // length not same will be false
         else if (s1.length()!=s2.length())
             isPermutation = false;
         else {
             //same length
             char[] chars1 = s1.toCharArray();
             char[] chars2 = s2.toCharArray();

             int[] charInt1 = new int[128];
             int[] charInt2 = new int[128];

             //count characters in each string
             int length = chars1.length;
             for(int i=0;i<length;i++){
                 charInt1[chars1[i]]++;
                 charInt2[chars2[i]]++;
             }

             //check if charInt1 same to charInt2
            for(int j=0;j<128;j++){
                 if (charInt1[j]!=charInt2[j]){
                     isPermutation=false;
                     break;
                 }
            }
        }

        return isPermutation;
    }

    static boolean isPermutation2(String s1, String s2){
        boolean isPermutation = true;
        //either s1 or s2 is null will return false
        if (s1==null || s2==null)
            isPermutation = false;
            // length not same will be false
        else if (s1.length()!=s2.length())
            isPermutation = false;
        else {
            //same length
            char[] chars1 = s1.toCharArray();

            int[] charInt1 = new int[128];

            //count characters in string
            int length = chars1.length;
            for(int i=0;i<length;i++){
                charInt1[chars1[i]]++;
            }

            for (int j=0;j<s2.length();j++){
                int c = s2.charAt(j);
                charInt1[c]--;
                if (charInt1[c]<0){
                    isPermutation = false;
                    break;
                }

            }

        }

        return isPermutation;
    }

    public static void main(String[] args){
        System.out.println("method 1:");
        System.out.println(isPermutation("god  ","dog"));
        System.out.println(isPermutation("god","dog"));
        System.out.println(isPermutation("go d","dog"));
        System.out.println(isPermutation("good","doog"));

        System.out.println("method 2:");
        System.out.println(isPermutation("god  ","dog"));
        System.out.println(isPermutation("god","dog"));
        System.out.println(isPermutation("go d","dog"));
        System.out.println(isPermutation("good","doog"));
    }

}