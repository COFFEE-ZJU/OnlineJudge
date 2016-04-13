package leetcode._2ndtime.no120;

import java.util.List;

/**
 * Whiteboard coding!
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty()) return 0;

        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < dp.length; i++) {
            List<Integer> list = triangle.get(i);
            for (int j = i; j >= 0; j--) {
                if (j == 0)
                    dp[j] = dp[j] + list.get(j);
                else if (j == i)
                    dp[j] = dp[j-1] + list.get(j);
                else {
                    dp[j] = Math.min(dp[j], dp[j-1]) + list.get(j);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int sum : dp) {
            min = Math.min(sum, min);
        }

        return min;
    }
}