package leetcode._2ndtime.no072;

/**
 * Whiteboard coding!
 */

public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return 0;
        int len1 = word1.length(), len2 = word2.length();
        int[] dp = new int[len1+1], dpPrev = new int[len1+1];
        for (int i = 0; i <= len1; i++) {
            dpPrev[i] = dp[i] = i;
        }
        for (int i = 1; i <= len2; i++) {
            char c2 = word2.charAt(i-1);
            dp[0] = i;
            for (int j = 1; j <= len1; j++) {
                char c1 = word1.charAt(j-1);
                if (c1 == c2) {
                    dp[j] = dpPrev[j-1];
                } else {
                    dp[j] = Math.min(dpPrev[j], Math.min(dp[j-1], dpPrev[j-1])) + 1;
                }
            }
            System.arraycopy(dp, 0, dpPrev, 0, len1+1);
        }
        return dp[len1];
    }
}