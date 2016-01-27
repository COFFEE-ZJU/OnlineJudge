package cn.edu.zju.coffee.leetcode.no122;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;

        int prev, profit;
        prev = prices[0];
        profit = 0;
        for (int p : prices){
            if (p > prev)
                profit += (p - prev);

            prev = p;
        }

        return profit;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
    }
}