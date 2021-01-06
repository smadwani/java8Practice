package madwani.sushil.leetcode.Jan1_7_2021;

import madwani.sushil.Util;

import java.util.ArrayList;
import java.util.List;

public class TwoSum {
    public static void main(String[] args) {
        Util.print1dArray(twoSum(new int[]{3,3}, 6));
    }

    public static int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0) return null;
        List<Integer> numbers = new ArrayList<Integer>() {{ for (int i : nums) add(i); }};

        for (int num : nums) {
            int index1 = numbers.indexOf(num);
            List<Integer> copy = new ArrayList<>(numbers);
            copy.remove(copy.indexOf(num));
            if (copy.contains(target - num)) {
                int index2 = copy.indexOf(target - num) + 1;
                return new int[]{ index1, index2};
            }
        }
        return null;
    }
}
