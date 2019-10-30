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
        int leftArrayLength = middle - start + 1;
        int rightArrayLength = end - middle;

        int[] tempLeft = new int[leftArrayLength];
        int[] tempRight = new int[rightArrayLength];
        for ( int i =0; i< leftArrayLength ;i++) {
            tempLeft[i] = arr[start + i];
        }
        for ( int i =0; i< rightArrayLength ;i++) {
            tempRight[i] = arr[middle + i + 1 ];
        }

        int i = 0, j = 0, k = start;
        while(i < leftArrayLength && j < rightArrayLength ) {
            if(tempLeft[i] <= tempRight[j]) {
                arr[k] = tempLeft[i];
                i++;
            } else{
                arr[k] = tempRight[j];
                j++;
            }
            k++;
        }

        while(i< leftArrayLength) {
            arr[k] = tempLeft[i];
            k++;i++;
        }

        while(j< rightArrayLength) {
            arr[k] = tempRight[j];
            k++;j++;
        }
    }
}
