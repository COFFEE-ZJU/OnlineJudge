package leetcode._2ndtime.no087;

/**
 * Whiteboard coding!
 */
public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null && s2 == null) return true;
        int len = s1.length();
        if (len != s2.length()) return false;
        if (len == 0) return true;

        boolean[][][] dp = new boolean[len][len][len];
        for (int ll = 0; ll < len; ll++) {
            for (int i = 0; i < len-ll; i++) {
                char c1 = s1.charAt(i);
                for (int j = 0; j < len-ll; j++) {
                    char c2 = s2.charAt(j);
                    if (ll == 0)
                        dp[ll][i][j] = c1 == c2;
                    else {
                        for (int ll1 = 0; ll1 < ll; ll1++) {
                            int ll2 = ll - 1 - ll1;
                            boolean tmp = (dp[ll1][i][j] && dp[ll2][i+ll1+1][j+ll1+1]) ||
                                    (dp[ll1][i][j+ll2+1] && dp[ll2][i+ll1+1][j]);
                            if (tmp) {
                                dp[ll][i][j] = true;
                                break;
                            }
                        }
                    }
                }
            }
        }

        return dp[len-1][0][0];
    }
}