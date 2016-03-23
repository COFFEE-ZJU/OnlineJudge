package leetcode.no322;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (coins == null || coins.length == 0 || amount < 0) return -1;

        int[][] dp = new int[coins.length+1][amount+1];
        for (int i = 1; i <= amount; i++)
            dp[0][i] = Integer.MAX_VALUE;
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                int c = coins[i-1];
                if (j < c || dp[i][j-c] == Integer.MAX_VALUE) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.min(dp[i-1][j], dp[i][j-c] + 1);
            }
        }

        int res = dp[coins.length][amount];
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.coinChange(new int[]{2}, 3));
        System.out.println(sol.coinChange(new int[]{1,2,5}, 11));
    }
}
