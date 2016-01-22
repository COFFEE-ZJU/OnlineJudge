package cn.edu.zju.coffee.leetcode.no097;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private char[] c1, c2, c3;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null)
            return false;
        if (s1.length() == 0)
            return s3.equals(s2);
        else if (s2.length() == 0)
            return s3.equals(s1);

        if (s1.length() > s2.length()){
            c1 = s2.toCharArray();
            c2 = s1.toCharArray();
        }
        else {
            c1 = s1.toCharArray();
            c2 = s2.toCharArray();
        }
        c3 = s3.toCharArray();
        if (c3.length != c1.length + c2.length)
            return false;

        List<int[]>[][] dp = new List[c1.length+1][c3.length+1];
        for (int i = 0; i <= c3.length; i++) {
            dp[0][i] = Collections.singletonList(new int[0]);
        }

        for (int i = 1; i <= c1.length; i++) {
            for (int j = i; j <= c3.length; j++) {
                dp[i][j] = new LinkedList<>();
                if (c1[i-1] == c3[j-1]){
                    for (int[] idxs : dp[i-1][j-1]){
                        int[] newis = Arrays.copyOf(idxs, i);
                        newis[i-1] = j-1;
                        dp[i][j].add(newis);
                    }
                }
                if (dp[i][j-1] != null)
                    dp[i][j].addAll(dp[i][j-1]);
            }
        }

        for (int[] idxs : dp[c1.length][c3.length]){
            if (tryFit(idxs))
                return true;
        }

        return false;
    }

    private boolean tryFit(int[] idxs){
        int k = 0, j = 0;
        for (int i = 0; i < c3.length; i++) {
            if (k < idxs.length && i == idxs[k])
                k++;
            else if (c2[j] == c3[i])
                j++;
            else
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isInterleave("a", "b", "ba"));
        System.out.println(sol.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(sol.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}