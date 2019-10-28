package madwani.sushil;

import java.util.stream.IntStream;

/***
 * Count frequencies of all elements in array in O(1) extra space and O(n) time
 */
public class MostOccurringElementInIntegerArrayOfNValues {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3,5,6,7,6,3,5,4,3};
        final int length  =nums.length;
        nums = IntStream.of(nums).map(e->e-1).toArray();
        for(int i=0; i< length;i++){
            nums[nums[i]] = nums[nums[i]] + length;
        }
        nums = IntStream.of(nums).map(n->n/length).filter(e->e!=0).toArray();
        for (int i =0; i< nums.length ;i++){
            System.out.println("frequency of " + (i+1) + " is :" + nums[i] );
        }

    }
}
