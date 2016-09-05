package leetcode._2ndtime.no242;

import java.util.Arrays;

/**
 * Whiteboard coding!
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == t) return true;
        if (s == null || t == null || s.length() != t.length()) return false;

        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(ts);
        return Arrays.equals(ss,ts);
    }
}