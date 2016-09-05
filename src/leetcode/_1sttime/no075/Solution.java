package leetcode._1sttime.no075;

import java.util.Arrays;

public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;

        int left = 0, right = nums.length - 1;
        for (int i = 0; i <= right; ) {
            if (nums[i] == 1)
                i++;
            else if (nums[i] == 0)
                swap(nums, left++, i++);
            else
                swap(nums, right--, i);
        }
    }

    private void swap(int[] nums, int ia, int ib){
        int tmp = nums[ia];
        nums[ia] = nums[ib];
        nums[ib] = tmp;
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
//        int[] nums = new int[]{0,0,0,0,0};
        int[] nums = new int[]{1};
        sol.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}