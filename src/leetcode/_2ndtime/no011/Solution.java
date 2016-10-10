package leetcode._2ndtime.no011;

/**
 * Whiteboard coding!
 */

public class Solution {
    public int maxArea(int[] height) {
        int len;
        if (height == null || (len = height.length) <= 1) return 0;

        int max = 0;
        for (int i = 0, j = len-1; i < j; ) {
            int hi = height[i], hj = height[j];
            max = Math.max(max, Math.min(hi, hj) * (j - i));
            if (hi > hj) j--;
            else i++;
        }
        return max;
    }
}