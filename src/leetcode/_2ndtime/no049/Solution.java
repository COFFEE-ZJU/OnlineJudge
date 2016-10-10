package leetcode._2ndtime.no049;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Whiteboard coding!
 */

public class Solution {
    private static class Word {
        final String str;
        final int[] cnts;

        private Word(String str) {
            this.str = str;
            cnts = new int[26];
            for (int i = 0; i < str.length(); i++) {
                cnts[str.charAt(i) - 'a'] ++;
            }
        }

        @Override
        public boolean equals(Object o) {
            Word word = (Word) o;

            return Arrays.equals(cnts, word.cnts);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(cnts);
        }
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        int len;
        if (strs == null || (len = strs.length) == 0) return Collections.emptyList();

        Map<Word, List<String>> map = new HashMap<>();
        for (String str : strs) {
            Word word = new Word(str);
            List<String> list = map.get(word);
            if (list == null) {
                list = new ArrayList<>();
                map.put(word, list);
            }
            list.add(str);
        }

        List<List<String>> res = new ArrayList<>(map.size());
        for (List<String> val : map.values()) {
            res.add(val);
        }
        return res;
    }
}