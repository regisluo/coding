package com.ttf.A02_basic_algo.sort;

import static com.ttf.A02_basic_algo.sort.SortUtil.swap;

import java.util.Arrays;

public class SelectionSort {

    // selection sorting the given array a, and return sorted array
    private static int[] selectionSort(int[] a){
        // boundary
        if(a==null || a.length<=1){
            return a;
        }

        int[] answer = Arrays.copyOf(a,a.length);

        // visit the array from the element after current
        for(int current=0;current<answer.length-1;current++){
            int minIndex = current;
            for(int i=current+1;i<answer.length;i++){
                if(answer[i]<answer[minIndex])
                    minIndex=i;
            }
            swap(answer, current, minIndex); // swap element in index current and minIndex
        }


        return answer;
    }


    private static void selectionSort2(int[] a){
        if (a==null) {
            return;
        }
        for (int i=0;i<a.length;i++) {
            int minIndex = i;
            for (int j=i+1;j<a.length;j++) {
                if (a[j] < a[minIndex]){
                    minIndex = j;
                }
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }

    }

    public static void main(String[] args){
        int[] a = new int[5];
        a[0]=3;
        a[1]=5;
        a[2]=1;
        a[3]=6;
        a[4]=2;
        int[] b=selectionSort(a);
        for(int i=0;i<b.length;i++){
            System.out.print(b[i]+" ");
        }
    }
}
