package leetcode._2ndtime.no055;

/**
 * Whiteboard coding!
 */
public class Solution {
    public boolean canJump(int[] nums) {
        int len;
        if (nums == null || (len=nums.length) == 0) return true;

        int maxIdx = 0;
        for (int i = 0; i < len; i++) {
            if (i > maxIdx) return false;

            maxIdx = Math.max(maxIdx, i + nums[i]);
        }
        return maxIdx >= len-1;
    }
}