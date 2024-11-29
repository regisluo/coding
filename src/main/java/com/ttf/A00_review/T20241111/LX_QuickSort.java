package com.ttf.A00_review.T20241111;

// practice for quick sort
public class LX_QuickSort {

    /**
     * Recursive-solution: quick sort for given arr whose index
     * from l (left) to r (right)
     */
    private static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length-1);
    }

    private static void process(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        //swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
        int[] equalIndices = partitioning(arr, L, R);
        process(arr, L, equalIndices[0] - 1);
        process(arr, equalIndices[1] + 1, R);
    }


    // partitioning the given arr make the pivot number in the right position;
    // and the smaller numbers before pivot, and numbers more than the pivot on the right
    private static int[] partitioning(int[] arr, int left, int right) {
        if (left > right) {
            return new int[]{-1, -1};
        }
        if (left == right) {
            return new int[]{left, right};
        }
        // index to indicate numbers less than pivot
        int less = left - 1;
        // index to indicate numbers no-less than pivot
        int more = right;
        // i is used to loop the arr, starting from index l
        int i = left;
        int pivot = arr[right];
        while (i < more) { // choose arr[right] as pivot
            // current less than pivot, increase the less index, and move
            // current to next index
            if (arr[i] < pivot) {
                swap(arr, i++, ++less);
            } else if (arr[i] == pivot) {// equals then move current index only
                i++;
            } else {// current more than pivot, increase more array;
                // as current is more than pivot, then swap it to more array
                swap(arr, i, --more);
                // here, i cannot increase as the number just swapped is not checked yet
            }
        }
        // here, the i meet the more. index more to the last pivot value, then
        // we need a final swap with the 'right' index
        swap(arr, more, right);
        return new int[]{less + 1, more};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        //0 - 14
        int[] arr = new int[]{3, 5, 7, 4, 3, 5, 8, 9, 0, 6, 3, 2, 1, 3, 5};

//        int pivot = 0 + (int)((arr.length)*Math.random());
//        System.out.println(pivot);
        quickSort(arr);
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
