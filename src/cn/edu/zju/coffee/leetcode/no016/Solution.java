package cn.edu.zju.coffee.leetcode.no016;

import java.util.*;

/**
 * Created by zkf on 2015/12/18.
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ret = 0;
        if(nums == null || nums.length < 3)
            return ret;

        Arrays.sort(nums);
        int minBias = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            int m = i+1, n = nums.length - 1;
            while(m < n){
                int sum = nums[i] + nums[m] + nums[n];
                int bias = Math.abs(target - sum);
                if (bias == 0)
                    return target;

                if(bias < minBias){
                    minBias = bias;
                    ret = sum;
                }

                if (sum < target)
                    m ++;
                else
                    n --;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

}
