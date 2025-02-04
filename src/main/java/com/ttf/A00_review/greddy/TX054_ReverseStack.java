package com.ttf.A00_review.greddy;

import java.util.Stack;

/**
 * Reverse a stack without using any extra space or structure, only use recursive
 */
public class TX054_ReverseStack {
    /**
     * pop the last element, the elements above no change
     */
    private static int removeLast(Stack<Integer> s) {
        int top = s.pop();
        if (s.isEmpty()){
            return top;
        } else {
            int last = removeLast(s);// last is the last element
            s.push(top);
            return last;
        }
    }

    public static void reverse(Stack<Integer> s) {
        if (s.isEmpty()){
            return;
        }
        int last = removeLast(s);
        reverse(s);
        s.push(last);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        while (!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        reverse(s);
        System.out.println("");
        while (!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }

    }

}
