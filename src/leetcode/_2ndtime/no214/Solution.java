package leetcode._2ndtime.no214;

/**
 * Whiteboard coding!
 */

public class Solution {
    public String shortestPalindrome(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) return "";

        int j = len / 2;
        int i = j;
        if (len % 2 == 0) i--;
        while (true) {
            int ii = i, jj = j;
            while (ii >= 0) {
                if (s.charAt(ii) != s.charAt(jj)) break;
                ii--;
                jj++;
            }
            if (ii < 0) return new StringBuilder(s.substring(jj)).reverse().append(s).toString();

            if (i == j) i--;
            else j--;
        }
    }
}