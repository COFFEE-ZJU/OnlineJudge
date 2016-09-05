package leetcode._1sttime.no279;

import java.util.Arrays;

public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, 1, n+1, Integer.MAX_VALUE);

        for (int a = 0; a <= n; a++) {
            for (int b = 0; a+b*b <= n; b++)
                dp[a+b*b] = Math.min(dp[a+b*b], dp[a]+1);
        }

        return dp[n];
    }

    public int numSquaresSlow(int n) {
        int max = (int)Math.sqrt(n);
        int[][] dp = new int[max+1][n+1];
        for (int i = 1; i <= n; i++)
            dp[0][i] = Integer.MAX_VALUE;
        for (int root = 1; root <= max; root++) {
            int sq = root*root;
            for (int i = 1; i <= n; i++) {
                if (i < sq) dp[root][i] = dp[root-1][i];
                else dp[root][i] = Math.min(dp[root-1][i], dp[root][i-sq]+1);
            }
        }
        return dp[max][n];
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.numSquares(12));
        System.out.println(sol.numSquares(13));
        System.out.println(sol.numSquares(264));
    }
}
