package com.ttf.A00_review;

public class LX_BinarySearch {
    /**
     * return the index of number found in the array; return -1 if not found
     */
    private static int binarySearch(int[] arr, int number) {
        int left = 0;
        int right = arr.length-1;
        while (left<=right) {
            int mid = left+((right-left)>>1);
            if (arr[mid]==number){
                return mid;
            } else if (arr[mid]<number) {
                left = mid+1;
            } else {
                right=mid-1;
            }
        }

        return -1;
    }

    private static int findTheLeftNoLessThan(int number, int[] arr){
        int left = 0;
        int right = arr.length-1;
        while (left<=right) {
            int mid = left+((right-left)>>1);
            if (arr[mid]>=number){
                right = mid;
                if (left==right){
                    return right;
                }
            } else {
                left = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,4,5,6,7,8,9};
        int number = 1;
        System.out.println(findTheLeftNoLessThan(number, arr));
    }

}
