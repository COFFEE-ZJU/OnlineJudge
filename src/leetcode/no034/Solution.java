package leetcode.no034;

import java.util.Arrays;

/**
 * Created by zkf on 12/31/15.
 */
public class Solution {
    private static final int[] NOT_FOUND = new int[]{-1, -1};

    public int[] searchRange(int[] nums, int target) {
        if (nums == null)
            return NOT_FOUND;
        int[] res =  search(nums, target, 0, nums.length);
        if (res != NOT_FOUND)
            res[1] --;
        return res;
    }

    private int[] search(int[] nums, int target, int start, int end){
        if (start >= end)
            return NOT_FOUND;

        int[] res = new int[2];
        if (target == nums[start] && target == nums[end-1]) {
            res[0] = start;
            res[1] = end;
            return res;
        }

        if (start + 1 == end)
            return NOT_FOUND;

        int mid = (start + end) / 2;
        int[] res1 = NOT_FOUND, res2 = NOT_FOUND;
        if (target <= nums[mid])
            res1 = search(nums, target, start, mid);
        if (target >= nums[mid])
            res2 = search(nums, target, mid, end);

        if (res1 == NOT_FOUND)
            return res2;
        if (res2 == NOT_FOUND)
            return res1;

        res1[1] = res2[1];
        return res1;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,8,8,8,8,10};
        System.out.println(Arrays.toString(new Solution().searchRange(nums, 0)));
    }
}