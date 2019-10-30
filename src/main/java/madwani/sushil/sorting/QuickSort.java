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
        if ( start >= end) {
            return;
        }
        if(start < end) {
            int middle = ( start + end ) /2;
            quicksort(arr, start, middle);
            quicksort(arr, middle + 1, end);
            swap(arr, start, end, middle);
        }
    }

    private static void swap(int[] arr, int start, int end, int middle) {
        int i = start; int j = middle + 1 ;
        while( i <= middle || j <= end) {
            if(arr[i] > arr[j]) {
                Util.swapElementsInArray(arr, i, j);
                i++;
            } else {
                j++;
            }
        }
    }
}
