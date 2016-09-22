package leetcode._2ndtime.no053;

/**
 * Whiteboard coding!
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null) return 0;

        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int n : nums) {
            cur += n;
            max = Math.max(max, cur);
            if (cur < 0) cur = 0;
        }
        return max;
    }
}