package cn.edu.zju.coffee.leetcode.no198;

public class Solution {
    public int rob(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0)
            return 0;

        int max = nums[0];
        int prev1 = nums[0], prev2 = 0;
        for (int i = 1; i < len; i++) {
            int np2 = Math.max(prev1, prev2);
            int np1 = Math.max(prev1, prev2+nums[i]);
            prev1 = np1; prev2 = np2;
            max = Math.max(prev1, prev2);
        }

        return max;
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();

    }
}
