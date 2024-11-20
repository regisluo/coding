package com.ttf.A02_basic_algo.sort;

import static com.ttf.A02_basic_algo.sort.SortUtil.swap;

public class InsertionSort {
    private static void insertionSort(int[] arr){
        if(arr==null || arr.length==1){
            return;
        }

        for(int i=0;i<arr.length;i++){
            for(int j=i;j>0;j--){
                if(arr[j-1]>arr[j]){
                    swap(arr,j-1,j);
                }
            }
        }
    }

    private static void insertionSort2(int[] arr){
        // given that arr[0] is alreay sorted;thus we start from arr[1]
       for(int i=1;i<arr.length;i++) {
           // use k to store the value of the current picked element
           int k = arr[i];
           int j = i-1; // j starting from the left position of the current index
           while (j>=0 && arr[j]>k){
               arr[j+1] = arr[j];
               j--;
           }
           arr[j+1] = k;
       }
    }



    public static void main(String[] args){
        int[] a = new int[5];
        a[0]=3;
        a[1]=5;
        a[2]=1;
        a[3]=6;
        a[4]=2;
        insertionSort2(a);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}
