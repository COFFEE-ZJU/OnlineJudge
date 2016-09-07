package leetcode._2ndtime.no045;

/**
 * Created by Zhangkefei on 2016/1/6.
 */
public class Solution {
    public int jump(int[] nums) {
        int len;
        if (nums == null || (len=nums.length) == 0) return 0;

        int step = 0, edge = 0, max = nums[0];
        for (int i = 1; i < len; i++) {
            if (edge >= len-1) return step;
            if (i > max) return -1;
            if (i > edge) {
                step++;
                edge = max;
            }

            max = Math.max(max, nums[i] + i);
        }
        return step;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().jump(new int[]{2,0,2,0,1}));
        System.out.println(new Solution().jump(new int[]{3,1,2,0,1}));
        System.out.println(new Solution().jump(new int[]{2,1,1,3,4}));
    }
}