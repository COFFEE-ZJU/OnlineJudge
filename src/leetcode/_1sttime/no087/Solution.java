package leetcode._1sttime.no087;

public class Solution {
    char[] c1, c2;
    int len;
    boolean[][][] dp;

    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || (len = s1.length()) != s2.length())
            return false;
        if (len <= 1)
            return s1.equals(s2);

        c1 = s1.toCharArray();
        c2 = s2.toCharArray();
        dp = new boolean[len][len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                dp[i][j][1] = c1[i] == c2[j];
            }
        }
        for (int k = 2; k < len; k++) {
            for (int i = 0; i < len - k + 1; i++) {
                for (int j = 0; j < len - k + 1; j++) {
                    dp[i][j][k] = false;
                    for (int l = 1; l < k; l++) {
                        if ((dp[i][j+l][k-l] && dp[i+k-l][j][l]) ||
                                (dp[i][j][l] && dp[i+l][j+l][k-l])){
                            dp[i][j][k] = true;
                            break;
                        }
                    }
                }
            }
        }

        for (int l = 1; l < len; l++) {
            if ((dp[0][l][len-l] && dp[len-l][0][l]) ||
                    (dp[0][0][l] && dp[l][l][len-l])){
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isScramble("abc", "acb"));
        System.out.println(sol.isScramble("abb", "bab"));
        System.out.println(sol.isScramble("great", "great"));
        System.out.println(sol.isScramble("great", "eatgr"));
        System.out.println(sol.isScramble("great", "rgeat"));
        System.out.println(sol.isScramble("great", "rgeat1"));
        System.out.println(sol.isScramble("great", "agert"));
        System.out.println(sol.isScramble("great", "ag"));
    }
}