package cn.edu.zju.coffee.leetcode.no091;

public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;

        char[] c = s.toCharArray();
        int[] dp = new int[c.length + 1];
        dp[0] = 1;
        if (isLegal(c[0]))
            dp[1] = 1;
        else
            return 0;

        for (int i = 1; i < c.length; i++) {
            dp[i+1] = 0;
            if (isLegal(c[i]))
                dp[i+1] += dp[i];

            if (isLegal(c[i-1], c[i]))
                dp[i+1] += dp[i-1];
        }

        return dp[c.length];
    }

    private boolean isLegal(char c){
        int ci = c - '0';
        return (ci >= 1 && ci <= 9);
    }

    private boolean isLegal(char c1, char c2){
        int ci = (c1 - '0') * 10 + (c2 - '0');
        return (ci >= 10 && ci <= 26);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numDecodings("0"));
        System.out.println(sol.numDecodings("1"));
        System.out.println(sol.numDecodings("12"));
        System.out.println(sol.numDecodings("1261"));
        System.out.println(sol.numDecodings("126012"));
    }
}