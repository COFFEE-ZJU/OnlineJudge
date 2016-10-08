package leetcode._2ndtime.no115;

import java.util.Arrays;

/**
 * Whiteboard coding!
 */

public class Solution {
    public int numDistinct(String s, String t) {
        if (s == null || t == null) return 1;
        int sl = s.length(), tl = t.length();
        int[] dp = new int[sl+1];
        Arrays.fill(dp, 1);
        int[] dpPrev = Arrays.copyOf(dp, sl+1);
        for (int i = 1; i <= tl; i++) {
            char tc = t.charAt(i-1);
            dp[0] = 0;
            for (int j = 1; j <= sl; j++) {
                char sc = s.charAt(j-1);
                dp[j] = tc == sc ? dpPrev[j-1] + dp[j-1] : dp[j-1];
            }
            int[] tmp = dp;
            dp = dpPrev;
            dpPrev = tmp;
        }
        return dpPrev[sl];
    }
}