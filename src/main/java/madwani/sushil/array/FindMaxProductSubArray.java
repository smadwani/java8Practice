package madwani.sushil.array;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class FindMaxProductSubArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i =0; i< n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }
        Set<Integer> sorted = new TreeSet<>(Comparator.reverseOrder());

        for (int i=0; i< nums.length; i++) {
            int product = 1;
            for (int j = i+1; j<nums.length; j++) {
                product = product*nums[j];
                sorted.add(nums[i] * product);
            }
        }
        int maxProduct = sorted.iterator().next();

        for (int i=0; i< nums.length; i++) {
            if (nums[i] > maxProduct) {
                maxProduct = nums[i];
            }
        }
        return maxProduct;

    }
}
