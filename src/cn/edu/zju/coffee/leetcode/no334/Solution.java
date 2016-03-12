package cn.edu.zju.coffee.leetcode.no334;

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) return false;

        int[] dp = new int[2];
        dp[0] = dp[1] = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n > dp[1]) return true;
            else if (n > dp[0] && n < dp[1]) dp[1] = n;
            else if (n < dp[0]) dp[0] = n;
        }

        return false;
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
    }
}
