package leetcode._2ndtime.no268;

/**
 * Whiteboard coding!
 */
public class Solution {
    public int missingNumber(int[] nums) {
        int res = 0, idx = 1;
        for (int n : nums) {
            res ^= n;
            res ^= idx++;
        }
        return res;
    }
}