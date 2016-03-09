package cn.edu.zju.coffee.leetcode.no319;

/**
 * 就是找 n 以内的完全平方数, 因为只有它们的因子个数是奇数
 *
 */
public class Solution {
    public int bulbSwitch(int n) {
        if (n <= 0) return 0;

        int cnt = 0;
        for (int i = 1; i * i <= n; i++)
            cnt ++;
        return cnt;
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
    }
}
