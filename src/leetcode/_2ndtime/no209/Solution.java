package leetcode._2ndtime.no209;

/**
 * Whiteboard coding!
 */

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0 || s <= 0) return 0;
        int sum = 0, i = 0, j = 0;
        int minLen = len + 1;
        while (j < len) {
            while (j < len && sum < s) {
                sum += nums[j++];
            }
            if (sum < s) break;
            while (i < j && sum >= s) {
                sum -= nums[i++];
            }
            minLen = Math.min(minLen, j - i + 1);
        }
        return minLen == len+1 ? 0 : minLen;
    }
}