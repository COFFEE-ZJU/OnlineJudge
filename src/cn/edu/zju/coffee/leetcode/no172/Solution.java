package cn.edu.zju.coffee.leetcode.no172;

public class Solution {
    public int trailingZeroes(int n) {
        int zos = 0;
        for (long i = 5; i <= n; i *= 5) {
            zos += n / i;
        }

        return zos;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.trailingZeroes(30));
    }
}