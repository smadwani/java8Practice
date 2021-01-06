package madwani.sushil.leetcode.Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aab"));
    }
    static int diff = 0, startIndex = 0;
    static boolean hasDups = false;
    public static int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        Map<Character, List<Integer>> charPosition = new HashMap<>();
        for (int i = 0; i< s.length(); i++) {
            charPosition.computeIfAbsent(s.charAt(i), e -> new ArrayList<>()).add(i);
        }
        for (List<Integer> positions: charPosition.values()){
            if (positions.size() == 1) {
                diff = 1;
            }
            hasDups = true;
            for (int i=0; i < positions.size() ; i++) {
                int d = positions.get(i+1) - positions.get(i);
                if ( d > diff) {
                    diff = d;
                    startIndex = positions.get(i);
                }
            }
        }
        return diff == 0 ? s.length() : diff;

    }
}
