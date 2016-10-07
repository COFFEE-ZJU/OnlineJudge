package leetcode._2ndtime.no003;

import java.util.Arrays;

/**
 * Whiteboard coding!
 */

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) return 0;
        int[] posMap = new int[128];
        Arrays.fill(posMap, -1);

        int max = 0;
        for (int i = 0, j = 0; i < len; ) {
            int dupPos = -1;
            while (i < len) {
                Character c = s.charAt(i);
                Integer pos = posMap[c];
                if (pos != null && pos >= j) {
                    dupPos = pos;
                    break;
                }
                posMap[c] = i;
                i++;
            }
            max = Math.max(max, i - j);
            j = dupPos+1;
        }
        return max;
    }
}