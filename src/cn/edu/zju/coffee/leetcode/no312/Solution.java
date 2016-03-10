package cn.edu.zju.coffee.leetcode.no312;

public class Solution {
    private int[] nums;
    private int len;
    public int maxCoins(int[] nums) {
        if (nums == null || (len=nums.length) == 0) return 0;
        if (len == 1) return nums[0];

        this.nums = nums;
        int[][] dp = new int[len][len];
        for (int ran = 0; ran < len; ran++) {
            for (int s = 0; s < len - ran; s++) {
                int e = s + ran;
                int max = Integer.MIN_VALUE;
                for (int i = s; i <= e; i++) {
                    int dp1 = i == 0 ? 0 : dp[s][i-1];
                    int dp2 = i == len-1 ? 0 : dp[i+1][e];
                    int cur = dp1 + dp2 + numAt(s-1) * numAt(i) * numAt(e+1);
                    if (cur > max) max = cur;
                }
                dp[s][e] = max;
            }
        }

        return dp[0][len-1];
    }

    private int numAt(int i) {
        if (i == -1 || i == len) return 1;
        else return nums[i];
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.maxCoins(new int[]{3, 1, 5, 8}));
    }
}
