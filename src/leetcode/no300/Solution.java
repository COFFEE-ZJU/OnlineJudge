package leetcode.no300;

import java.util.Arrays;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int st = 0, end = nums.length;
            int cur = nums[i];
            while (st < end) {
                int mid = (st + end) / 2;
                if (dp[mid] < cur)
                    st = mid + 1;
                else
                    end = mid;
            }
            dp[st] = cur;
            max = Math.max(max, st);
        }

        return max + 1;
    }

    public int lengthOfLIS_N2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i], max);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
