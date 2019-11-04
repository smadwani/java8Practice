package madwani.sushil.sorting;

import madwani.sushil.Util;

public class MergeSort {

    public static void main(String[] args) {
        String input = Util.readLine();
        int[] elements = Util.convertLineToIntArray(input);
        mergesort(elements, 0, elements.length-1);
        Util.print1dArray(elements);
    }

    public static void mergesort(int[] arr, int start, int end) {
        if(start < end) {
            int middle = ( start + end ) /2;
            mergesort(arr, start, middle);
            mergesort(arr, middle + 1, end);
            merge(arr, start, end, middle);
        }
    }

    private static void merge(int[] arr, int start, int end, int middle) {

        // left array size to keep left side elements
        int leftArrayLength = middle - start + 1;

        // right array size to keep right side elements
        int rightArrayLength = end - middle;

        int[] tempLeft = new int[leftArrayLength];
        int[] tempRight = new int[rightArrayLength];

        // temporary populate temp left array with left elements
        for ( int i =0; i< leftArrayLength ;i++) {
            tempLeft[i] = arr[start + i];
        }

        // temporary populate temp right array with right elements
        for ( int i =0; i< rightArrayLength ;i++) {
            tempRight[i] = arr[middle + i + 1 ];
        }

        //lets actual merge starts

        // i for left array
        // j for right array
        // k for merged array
        int i = 0, j = 0, k = start;

        while(i < leftArrayLength && j < rightArrayLength ) {

            // if left element is lesser than right element
            if(tempLeft[i] <= tempRight[j]) {
                arr[k] = tempLeft[i];
                i++;
            } else{
                // if right element is lesser than left element
                arr[k] = tempRight[j];
                j++;
            }
            k++;
        }

        // populate remaining left element
        while(i< leftArrayLength) {
            arr[k] = tempLeft[i];
            k++;i++;
        }

        // populate remaining right element
        while(j< rightArrayLength) {
            arr[k] = tempRight[j];
            k++;j++;
        }
    }
}
