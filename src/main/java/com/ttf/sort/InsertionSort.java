package com.ttf.sort;
import static com.ttf.sort.SortUtil.swap;

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

    public static void main(String[] args){
        int[] a = new int[5];
        a[0]=3;
        a[1]=5;
        a[2]=1;
        a[3]=6;
        a[4]=2;
        insertionSort(a);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}
