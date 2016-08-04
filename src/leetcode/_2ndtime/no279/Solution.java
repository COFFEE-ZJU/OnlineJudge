package leetcode._2ndtime.no279;

/**
 * Whiteboard coding!
 */
public class Solution {
    public int numSquares(int n) {
        if (n <= 0) throw new IllegalArgumentException();
        int[] dp = new int[n+1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }

        int cur = 2;
        int sqr;
        while ((sqr = cur * cur) <= n) {
            for (int i = 0; i <= n - sqr; i++) {
                dp[i+sqr] = Math.min(dp[i+sqr], dp[i]+1);
            }

            cur++;
        }

        return dp[n];
    }
}
