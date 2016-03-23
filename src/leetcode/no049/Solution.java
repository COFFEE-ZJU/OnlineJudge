package leetcode.no049;

import java.util.*;

/**
 * Created by zkf on 1/7/16.
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<WordKey, List<String>> map = new HashMap<>();

        if (strs == null || strs.length == 0)
            return toList(map);

        for (String s : strs){
            WordKey key = new WordKey(s);
            List<String> set = map.get(key);
            if (set == null){
                set = new LinkedList<>();
                map.put(key, set);
            }
            set.add(s);
        }

        return toList(map);
    }

    private static List<List<String>> toList(Map<WordKey, List<String>> map){
        List<List<String>> list = new LinkedList<>();
        for (List<String> l : map.values()) {
            Collections.sort(l);
            list.add(l);
        }

        return list;
    }

    private static class WordKey{
        int[] cnts = new int[26];

        WordKey(String word){
            for (char c : word.toCharArray())
                cnts[c-'a'] ++;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            WordKey wordKey = (WordKey) o;

            return Arrays.equals(cnts, wordKey.cnts);

        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(cnts);
        }
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"", ""};
//        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        Solution sol = new Solution();
        System.out.println(sol.groupAnagrams(strs));
    }
}
