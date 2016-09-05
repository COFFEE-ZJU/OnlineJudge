package leetcode._1sttime.no115;

public class Solution {
    public int numDistinct(String s, String t) {
        if (s == null || t == null)
            return 0;
        int slen = s.length(), tlen = t.length();
        if (tlen == 0)
            return 1;
        if (slen == 0)
            return 0;

        int[][] dp = new int[tlen+1][slen+1];
        for (int i = 0; i < slen+1; i++)
            dp[0][i] = 1;

        for (int i = 1; i <= tlen ; i++) {
            for (int j = i; j <= slen; j++) {
                dp[i][j] = dp[i][j-1];
                if (t.charAt(i-1) == s.charAt(j-1))
                    dp[i][j] += dp[i-1][j-1];
            }
        }

        return dp[tlen][slen];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numDistinct("rabbbit", "rabbit"));
        System.out.println(sol.numDistinct("rabbit", "rabbit"));
        System.out.println(sol.numDistinct("abc", "rabbit"));
        System.out.println(sol.numDistinct("abcdabc", "abc"));
    }
}