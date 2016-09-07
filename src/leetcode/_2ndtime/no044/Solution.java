package leetcode._2ndtime.no044;

/**
 * Created by Zhangkefei on 2016/1/6.
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        int sl = s.length(), pl = p.length();
        boolean[][] dp = new boolean[pl+1][sl+1];
        dp[0][0] = true;
        for (int i = 1; i <= pl; i++) {
            char pc = p.charAt(i-1);
            if (pc == '*')
                dp[i][0] = dp[i-1][0];
            for (int j = 1; j <= sl; j++) {
                char sc = s.charAt(j-1);
                if (pc == '*') dp[i][j] = dp[i-1][j] || dp[i][j-1];
                else if (pc == '?' || pc == sc) dp[i][j] = dp[i-1][j-1];
            }
        }
        return dp[pl][sl];
    }
}
