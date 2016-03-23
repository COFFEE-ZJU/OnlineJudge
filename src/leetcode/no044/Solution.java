package leetcode.no044;

import java.util.*;

/**
 * Created by Zhangkefei on 2016/1/6.
 */
public class Solution {
    public boolean isMatchDp(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        int lens = s.length();
        int lenp = p.length();

        // 创建一个Dp二维数组
        boolean[][] dp = new boolean[lens + 1][lenp + 1];

        boolean flag = false;

        for (int i = 0; i <= lens; i++) {
            flag = false;
            for (int j = 0; j <= lenp; j++) {
                // both is empty.
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                    flag = true;
                    continue;
                }

                // if P is empty, s is not empty, it is false.
                if (j == 0) {
                    dp[i][j] = false;
                    continue;
                }

                // if S is empty, P is not empty
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && p.charAt(j - 1) == '*';
                } else {
                    dp[i][j] = (canMatch(s.charAt(i - 1), p.charAt(j - 1)) && dp[i - 1][j - 1])
                            || (p.charAt(j - 1) == '*' && (dp[i][j - 1] || dp[i - 1][j]));
                }

                if (dp[i][j]) {
                    flag = true;
                }

                // Greedy. 在此即可以退出，因为* 可以匹配余下的所有的字符串。
                if (dp[i][j] && p.charAt(j - 1) == '*' && j == lenp) {
                    return true;
                }
            }

            if (!flag) {
                return false;
            }
        }

        return dp[lens][lenp];
    }

    private Set<Pair> falseSet = new HashSet<>();

    public boolean isMatch(String s, String p) {
        if (s == null && p == null)
            return true;
        if (s == null || p == null)
            return false;

        falseSet.clear();
        List<Character> list = new LinkedList<>();
        char prev = 'a';
        for (char c : p.toCharArray()){
            if (c == prev && c == '*')
                continue;

            list.add(c);
            prev = c;
        }

        char[] pchars = new char[list.size()];
        int i = 0;
        for (char c : list)
            pchars[i++] = c;

        return isMatch(s.toCharArray(), 0, pchars, 0);
    }

    private boolean isMatch(char[] s, int ss, char[] p, int ps){
        if (ss >= s.length && ps >= p.length)
            return true;

        if (ss >= s.length){
            for (int i = ps; i < p.length; i++) {
                if (p[i] != '*')
                    return false;
            }
            return true;
        }

        if (ps >= p.length)
            return false;

        if (falseSet.contains(new Pair(ss, ps)))
            return false;

        if (p[ps] != '*'){
            if (! canMatch(s[ss], p[ps]))
                return false;

            return isMatch(s, ss+1, p, ps+1);
        }
        else {
            for (int i = ss; i <= s.length; i++) {
                if (isMatch(s, i, p, ps+1))
                    return true;
                else
                    falseSet.add(new Pair(i, ps+1));
            }

            return false;
        }
    }

    private boolean canMatch(char s, char p){
        return (p == '?') ? true : p == s;
    }

    private static class Pair{
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (x != pair.x) return false;
            return y == pair.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 310 * result + y;
            return result;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
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
