package leetcode._2ndtime.no392;

/**
 * Whiteboard coding!
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        int sLen, tLen;
        if (s == t || s == null || (sLen=s.length()) == 0) return true;
        if (t == null || (tLen=t.length()) < sLen) return false;

        int si = 0;
        for (int ti = 0; ti < tLen; ti++) {
            if (si == sLen) return true;
            if (sLen-si > tLen-ti) return false;
            if (t.charAt(ti) == s.charAt(si)) si++;
        }
        return si == sLen;
    }
}