package com.ttf.old.erfen;

public class BinarySearch {
    public static boolean findNInOrderArray(int[] orderedArray, int number) {
        boolean found = false;
        // edge cases
        if (orderedArray == null) {
            return found;
        } else if (orderedArray.length == 1) {
            found = orderedArray[0] == number;
        } else {
            int left = 0;
            int right = orderedArray.length - 1;

            while (left <= right) {
                int middle = (left + right) / 2;
                if (orderedArray[middle] > number) {
                    right = middle - 1;
                } else if (orderedArray[middle] < number) {
                    left = middle + 1;
                } else {
                    found = true;
                    break;
                }
                ;

            }
        }
        return found;
    }

    /**
     * find the most left index in the ordered array, whose value is no less than given number n
     *
     * @return the most left index
     */
    public static int findLeftestBigThan(int[] numbers, int n) {
        int index = -1; // initial -1 to indicate not found
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (numbers[mid] < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
                index = mid;
            }
        }
        return index;
    }

    public static int findRightestSmallerThan(int[] numbers, int n) {
        int index = -1; // initial -1 to indicate not found
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (numbers[mid] > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
                index = mid;
            }
        }
        return index;
    }


    public static void main(String[] args) {
        int[] test = {1, 2, 3, 3, 4,4,4, 5, 6, 10, 11};
        int number = 3;
        // System.out.println(findNInOrderArray(test, number));
        System.out.println(findLeftestBigThan(test, number));
        System.out.println(findRightestSmallerThan(test,4));

    }
}
