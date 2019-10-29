package madwani.sushil.sorting;

import madwani.sushil.Util;

public class BubbleSort {
    public static void main(String[] args) {
        String input = Util.readLine();
        int[] elements = Util.convertLineToIntArray(input);
        int length = elements.length;
        for(int i=0; i< length;length--){
            for(int j=0; j < length-1; j++){
                if(elements[j] > elements[j+1]) {
                    elements = Util.swapElementsInArray(elements, j, j+1);
                }
            }
        }
        Util.print1dArray(elements);
    }
}
