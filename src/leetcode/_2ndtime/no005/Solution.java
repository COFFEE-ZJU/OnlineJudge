package leetcode._2ndtime.no005;

/**
 * Whiteboard coding!
 */

public class Solution {
    public String longestPalindrome(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) return "";

        int max = 0, st = 0, end = 1;
        for (int i = 0, j = 0; j < len; ) {
            int ii = i, jj = j;
            while (ii >= 0 && jj < len && s.charAt(ii) == s.charAt(jj)) {
                ii--;
                jj++;
            }
            ii++;
            if (max < jj - ii) {
                max = jj - ii;
                st = ii;
                end = jj;
            }

            if (i == j) j++;
            else i++;
        }

        return s.substring(st, end);
    }
}