package cn.edu.zju.coffee.leetcode.no152;

public class Solution {
    public int maxProduct(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) return 0;
        if (len == 1) return nums[0];
        int max, min;
        max = Integer.MIN_VALUE; min = Integer.MAX_VALUE;
        int preMax, preMin;
        preMax = preMin = 1;
        for (int n : nums){
            int r1 = preMax * n, r2 = preMin * n;
            preMax = Math.max(Math.max(r1,r2),n);
            preMin = Math.min(Math.min(r1,r2),n);
            max = Math.max(preMax, max);
            min = Math.min(preMin, min);
        }

        return max;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxProduct(new int[]{2,3,-2,4}));
        System.out.println(sol.maxProduct(new int[]{0,1,-2,3}));
        System.out.println(sol.maxProduct(new int[]{0,-2}));
        System.out.println(sol.maxProduct(new int[]{-2}));
        System.out.println(sol.maxProduct(new int[]{0}));
        System.out.println(sol.maxProduct(new int[]{5}));
    }
}
