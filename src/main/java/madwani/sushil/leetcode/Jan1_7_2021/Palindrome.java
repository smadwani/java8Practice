package madwani.sushil.leetcode.Jan1_7_2021;

import java.util.*;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(canPermutePalindrome2("code"));
    }

    public static boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 1) {
            return true;
        }
        int oddCount = 0;
        Map<Character, Integer> charCount = new HashMap<>();
        for (int i=0 ; i < s.length(); i++) {
            charCount.merge(s.charAt(i), 1, Integer::sum);
        }
        for (Integer count: charCount.values()) {
            if (count % 2 != 0) {
                oddCount++;
            }
            if (oddCount > 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean canPermutePalindrome1(String s) {
       Set<Character> charSet = new HashSet<>();
       for (int i = 0; i < s.length(); i++ ) {
           if(!charSet.add(s.charAt(i))) {
               charSet.remove(s.charAt(i));
           }
       }
       return charSet.size() <= 1;
    }

    public static boolean canPermutePalindrome2(String s) {
        BitSet bitSet = new BitSet();
        for (int i = 0; i < s.length(); i++ ) {
            bitSet.flip(Character.getNumericValue(s.charAt(i)));
        }
        return bitSet.stream().count() <=1;
    }
}
