package leetcode._2ndtime.no260;

/**
 * Whiteboard coding!
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length < 2) return null;

        int xor = 0;
        for (int n : nums) xor = xor ^ n;
        int lowbit = xor & (-xor);
        int a = 0, b = 0;
        for (int n : nums) {
            if ((n & lowbit) == 0) a = a ^ n;
            else b = b ^ n;
        }
        return new int[]{a, b};
    }
}