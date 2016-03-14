package cn.edu.zju.coffee.leetcode.no070;

public class Solution {
    public int climbStairs(int n) {
        if (n <= 1) return 1;
        int pp = 1, p = 1;
        for (int i = 1; i < n; i++) {
            int cur = p + pp;
            pp = p;
            p = cur;
        }

        return p;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
	}
}