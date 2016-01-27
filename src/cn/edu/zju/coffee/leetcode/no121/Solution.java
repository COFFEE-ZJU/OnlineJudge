package cn.edu.zju.coffee.leetcode.no121;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;

        int curMin, profit;
        curMin = prices[0];
        profit = 0;
        for (int p : prices){
            if (p < curMin)
                curMin = p;

            if (p - curMin > profit)
                profit = p - curMin;
        }

        return profit;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
    }
}