package com.ttf.A02_basic_algo.sort;

import static com.ttf.A02_basic_algo.sort.SortUtil.swap;

public class BubbleSort {

    private static void bubbleSort(int[] arr){
        // compare adjacent elements and swap if needed
        // each bubble will make the max(or min) to the last

        //boundary
        if(arr==null || arr.length==1){
            return;
        }

        for(int i=arr.length-1;i>0;i--){
            for(int j=0;j<i;j++){
                if (arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    public static void main(String[] args){
        int[] a = new int[5];
        a[0]=3;
        a[1]=5;
        a[2]=1;
        a[3]=6;
        a[4]=2;
        bubbleSort(a);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}
