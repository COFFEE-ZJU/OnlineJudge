package cn.edu.zju.coffee.leetcode.no213;

public class Solution {
    public int rob(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0)
            return 0;
        if (len == 1)
            return nums[0];

        int max1 = nums[0];
        int prev1 = nums[0], prev2 = 0;
        for (int i = 1; i < len-1; i++) {
            int np2 = Math.max(prev1, prev2);
            int np1 = Math.max(prev1, prev2+nums[i]);
            prev1 = np1; prev2 = np2;
            max1 = Math.max(prev1, prev2);
        }

        int max2 = nums[1];
        prev1 = nums[1]; prev2 = 0;
        for (int i = 2; i < len; i++) {
            int np2 = Math.max(prev1, prev2);
            int np1 = Math.max(prev1, prev2+nums[i]);
            prev1 = np1; prev2 = np2;
            max2 = Math.max(prev1, prev2);
        }

        return Math.max(max1, max2);
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();

    }
}
