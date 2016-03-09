package cn.edu.zju.coffee.leetcode.no309;

public class Solution {
    public int maxProfit(int[] prices) {
        int sell = 0, sellPrev = 0, buy = Integer.MIN_VALUE;
        for (int p : prices) {
            int nSell = Math.max(buy + p, sell);
            int nBuy = Math.max(sellPrev - p, buy);
            buy = nBuy;
            sellPrev = sell;
            sell = nSell;
        }

        return sell;
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.maxProfit(new int[]{1, 2, 3, 0, 2}));
    }
}
