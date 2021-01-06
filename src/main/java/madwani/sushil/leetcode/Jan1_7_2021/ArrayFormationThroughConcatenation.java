package madwani.sushil.leetcode.Jan1_7_2021;

import java.util.ArrayList;
import java.util.List;

public class ArrayFormationThroughConcatenation {
    public static void main(String[] args) {
        int[] arr = { 1,3,5,7 };
        int [][] pieces = {{2,4,6,8}};
        System.out.println(canFormArray(arr, pieces));
    }

    public static boolean canFormArray(int[] arr, int[][] pieces) {

        List<Integer> array = new ArrayList<Integer>() {{ for (int i : arr) add(i); }};
        for (int [] piece : pieces) {
            int previousIndex = -1;
            for (int p : piece) {
                if (!array.contains(p)) {
                    return false;
                }
                if (previousIndex != -1 && previousIndex + 1 != array.indexOf(p)) {
                    return false;
                }
                previousIndex = array.indexOf(p);
            }
        }
        return true;
    }
}
