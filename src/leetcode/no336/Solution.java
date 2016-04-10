package leetcode.no336;

import java.util.*;

public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> pairs = new LinkedList<>();
        if (words == null) return pairs;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; ++ i) map.put(words[i], i);
        for (int i = 0; i < words.length; ++ i) {
            String w = words[i];
            for (int j = 0; j <= w.length(); j++) {
                String key = new StringBuilder(w.substring(0,j)).reverse().toString();
                Integer idx = map.get(key);
                if (idx != null && i != idx && isPali(w, j, w.length()-1))
                    pairs.add(Arrays.asList(i, idx));
            }
            for (int j = 1; j <= w.length(); j++) {
                String key = new StringBuilder(w.substring(j, w.length())).reverse().toString();
                Integer idx = map.get(key);
                if (idx != null && i != idx && isPali(w, 0, j-1))
                    pairs.add(Arrays.asList(idx, i));
            }
        }
        return pairs;
    }

    private boolean isPali(String word, int left, int right) {
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }

    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length()/2; ++ i)
            if (s.charAt(i) != s.charAt(s.length()-1-i))
                return false;
        return true;
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.palindromePairs(new String[]{
//                "bat", "tab", "cat"
                "abcd", "dcba", "lls", "s", "sssll"
        }));
    }
}
