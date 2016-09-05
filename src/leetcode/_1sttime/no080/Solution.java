package leetcode._1sttime.no080;

import java.util.Arrays;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int idx1 = 1;
        for (int idx2 = 1, cnt = 0; idx2 < nums.length; idx2 ++){
            if (nums[idx2] == nums[idx2-1] && (++cnt) >= 2)
                continue;

            if (nums[idx2] != nums[idx2-1])
                cnt = 0;

            nums[idx1++] = nums[idx2];
        }
        return idx1;
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        int[] nums = new int[]{1,1,1,1,2,2,2,3};
        System.out.println(sol.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}