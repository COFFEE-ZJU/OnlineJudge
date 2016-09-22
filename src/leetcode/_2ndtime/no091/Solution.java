package leetcode._2ndtime.no091;

/**
 * Whiteboard coding!
 */
public class Solution {
    public int numDecodings(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) return 0;

        int[] dp = new int[len + 1];
        dp[0] = 1;
        for (int i = 0; i < len; i++) {
            int c = s.charAt(i) - '0';
            if (i == 0) {
                if (c >= 1 && c <= 9) dp[i+1] = 1;
                else dp[i+1] = 0;
            } else {
                if (c >= 1 && c <= 9) dp[i+1] = dp[i];
                c += 10 * (s.charAt(i-1) - '0');
                if (c >= 10 && c <= 26) dp[i+1] += dp[i-1];
            }
        }
        return dp[len];
    }
}