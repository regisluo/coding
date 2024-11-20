package com.ttf.old.A01_tixiban;

public class TX08_CountDoubleSmaller {
    public static int countDoubleSmaller(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    /**
     * recursive function to sort the arr desc;
     * along the process, count the number double smaller than the current one
     */
    public static int process(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + ((right - left) >> 1);

        return process(arr, left, mid) + process(arr, mid + 1, right)
                + mergeAndCount(arr, left, mid, right);
    }

    public static int mergeAndCount(int[] arr, int left, int mid, int right) {
        int p1 = left;
        int p2;
        int count = 0;
        while (p1 <= mid) {
            p2 = mid + 1;
            while (p2 <= right && arr[p1] > 2 * arr[p2]) {
                p2++;
            }
            count += (p2 - (mid + 1));
            p1++;
        }

        p1 = left;
        p2 = mid + 1;
        int i = 0;
        int[] help = new int[right - left + 1];
        while (p1 <= mid && p2 <= right) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }

        while (p2 <= right) {
            help[i++] = arr[p2++];
        }

        for (int k = 0; k < help.length; k++) {
            arr[left + k] = help[k];
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {9, 4, 6, 2, 3};
        int result = countDoubleSmaller(nums);
        System.out.println("累加的值是: " + result);
    }
}
