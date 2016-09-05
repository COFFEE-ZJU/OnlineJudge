package leetcode._1sttime.no318;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int maxProduct(String[] words) {
        if (words == null || words.length < 2) return 0;

        int[] bss = new int[words.length];
        for (int i = 0; i < words.length; i++)
            bss[i] = genBitSet(words[i]);

        int max = 0;
        for (int i = 0; i < words.length-1; i++) {
            int tLen = words[i].length();
            for (int j = i+1; j < words.length; j++) {
                if ((bss[i] & bss[j]) == 0) {
                    int cur = tLen * words[j].length();
                    if (cur > max) max = cur;
                }
            }
        }

        return max;
    }

    /**
     * 看上去这个更科学， 但是事实上比较慢
     * @param words
     * @return
     */
    public int maxProduct2(String[] words) {
        if (words == null || words.length < 2) return 0;

        Arrays.sort(words, Comparator.comparing(String::length).reversed());
        int[] bss = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            bss[i] = genBitSet(words[i]);
        }

        int max = 0;
        for (int i = 0; i < words.length-1; i++) {
            int tLen = words[i].length();
            if (tLen * tLen <= max) break;
            for (int j = i+1; j < words.length; j++) {
                if ((bss[i] & bss[j]) == 0) {
                    int cur = tLen * words[j].length();
                    if (cur > max) max = cur;
                    break;
                }
            }
        }

        return max;
    }

    private int genBitSet(String w) {
        int res = 0;
        for (int i = 0; i < w.length(); i++)
            res |= 1 << (w.charAt(i)-'a');

        return res;
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
        System.out.println(sol.maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}));
        System.out.println(sol.maxProduct(new String[]{"a", "aa", "aaa", "aaaa"}));
    }
}
