package com.ttf.A00_review.greddy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formattable;
import java.util.List;

public class TX053_StringPermutation {

    public static List<String> permutation1(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return ans;
        }
        char[] str = s.toCharArray();
        ArrayList<Character> rest = new ArrayList<Character>();
        for (char cha : str) {
            rest.add(cha);
        }
        String path = "";
        f(rest, path, ans);
        return ans;
    }

    public static void f(ArrayList<Character> rest, String path, List<String> ans) {
        boolean[] visited = new boolean[256];
       if (rest.isEmpty()) {
           ans.add(path);
       } else {
           int N = rest.size();
           for(int i=0;i<N;i++) {
               if (!visited[rest.get(i)]) {
                   visited[rest.get(i)] = true;
                   Character cur = rest.remove(i);
                   f(rest, path+cur, ans);
                   rest.add(i, cur);
               }
           }
       }
    }

    public static void main(String[] args) {
        TX053_StringPermutation ins = new TX053_StringPermutation();
        List<String> ans = ins.permutation1("aac");
        for(int i=0;i<ans.size();i++) {
            System.out.println(ans.get(i));
        }
    }
    
}
