package leetcode._1sttime.no188;

import java.util.Arrays;

public class Solution {
	public int maxProfit(int k, int[] prices) {
		if(prices == null || prices.length <= 1 || k <= 0) return 0;
        int len = prices.length;
        int[] curMin = Arrays.copyOf(prices, len);
        if (k > len - 1) k = len - 1;
        int[][] dp = new int[k][len];

        for (int i = 1; i < len; i++) {
            int cur = prices[i];
            if (cur < curMin[0]) curMin[0] = cur;
            dp[0][i] = cur - curMin[0];
            int maxK = i-1 < k ? i-1 : k;
            for (int j = 0; j < i; j++) {
                if (cur < curMin[j]) curMin[j] = cur;
                int pro = cur - curMin[j];

                for (int kk = 0; kk < maxK-1; kk++) {
                    if (dp[kk+1][i] < dp[kk][j] + pro)
                        dp[kk+1][i] = dp[kk][j] + pro;
                }
            }
        }

		int max = 0;
        for (int pros : dp[k-1]){
            if (max < pros) max = pros;
        }
        return max;
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.maxProfit(1, new int[]{1,2,0,3}));
        System.out.println(sol.maxProfit(2, new int[]{1,2,0,3}));
    }
}
