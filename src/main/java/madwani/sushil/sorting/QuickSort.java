package madwani.sushil.sorting;

import madwani.sushil.Util;

public class QuickSort {
    public static void main(String[] args) {
        String input = Util.readLine();
        int[] elements = Util.convertLineToIntArray(input);
        quicksort(elements, 0, elements.length-1);
        Util.print1dArray(elements);
    }

    public static void quicksort(int[] arr, int start, int end) {

        // basic check to ensure corner case

        if (arr == null || arr.length == 0) {

            return;

        }

        // condition to break recursion

        if (start >= end) {

            return;

        }

        // I always chose middle element as Pivot

        int middle = start + (end - start) / 2;

        // Pivot element

        int pivot = arr[middle];

        // lets start the real sorting

        int i = start, j = end;

        // do comparison and swapping till start and end have not met

        while (i <= j) {

            // increment till left side elements are lesser or equal to pivot

            while (arr[i] < pivot) {

                i++;

            }

            // decrement till right side elements are greater to pivot

            while (arr[j] > pivot) {

                j--;

            }

            // swap elements from left right only when indices haven't crossed each other

            // after swap always increase lower index and decrease higher index

            if (i <= j) {

                Util.swapElementsInArray(arr, i, j);

                i++;

                j--;

            }

        }

        // one pass is done, so we have 2 boundaries
        // lower boundary: i which was moving towards end
        // upper boundary: j which was moving towards start



        // if i has not reached and crossed the end lets do one more pass from i to end
        // this is left subarray

        if (end > i) {
            quicksort(arr, i, end);
        }

        // if j has not reached the start and crossed, lets do one more pass from start to j
        // this is right subarray

        if (start < j) {
            quicksort(arr, start, j);
        }
    }
}
