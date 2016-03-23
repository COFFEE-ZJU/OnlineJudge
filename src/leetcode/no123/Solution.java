package leetcode.no123;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;

        int[] order = new int[prices.length];
        int[] rev = new int[prices.length];

        int curMin, curMax, profit;
        curMin = prices[0];
        profit = 0;
        int i = 0;
        for (int p : prices){
            if (p < curMin)
                curMin = p;

            if (p - curMin > profit)
                profit = p - curMin;

            order[i++] = profit;
        }

        i = prices.length-1;
        curMax = prices[i];
        profit = 0;
        for(; i>=0;){
            if (prices[i] > curMax)
                curMax = prices[i];

            if (curMax - prices[i] > profit)
                profit = curMax-prices[i];

            rev[i--] = profit;
        }

        int max = 0;
        for (i = 0; i < prices.length; i++) {
            if (order[i] + rev[i] > max)
                max = order[i] + rev[i];
        }

        return max;

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
    }
}