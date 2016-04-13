package leetcode._2ndtime.no044;

/**
 * Created by Zhangkefei on 2016/1/6.
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        int slen = s.length(), plen = p.length();
        boolean[][] dp = new boolean[plen+1][slen+1];
        dp[0][0] = true;
        for (int i = 1; i <= plen; i++) {
            char c = p.charAt(i-1);
            if (c == '*')
                dp[i][0] = dp[i-1][0];
            for (int j = 1; j <= slen; j++) {
                if (c == '*') {
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }
                else if (c == '?') {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = dp[i-1][j-1] && c == s.charAt(j-1);
                }
            }
        }

        return dp[plen][slen];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isMatch("a","a*"));
        System.out.println(sol.isMatch("","a"));
        System.out.println(sol.isMatch("","**"));
        System.out.println(sol.isMatch("aa","a"));
        System.out.println(sol.isMatch("aa","aa"));
        System.out.println(sol.isMatch("aaa","aa"));
        System.out.println(sol.isMatch("aa","*"));
        System.out.println(sol.isMatch("aa","a*"));
        System.out.println(sol.isMatch("ab","?*"));
        System.out.println(sol.isMatch("aab","c*a*b*"));
    }
}
