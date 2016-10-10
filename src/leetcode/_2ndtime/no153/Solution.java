package leetcode._2ndtime.no153;

/**
 * Whiteboard coding!
 */

public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return Integer.MIN_VALUE;

        return findMin(nums, 0, nums.length-1);
    }

    private int findMin(int[] nums, int st, int end) {
        if (st == end) return nums[st];
        if (st+1 == end) return Math.min(nums[st], nums[end]);
        if (nums[end] > nums[st]) return nums[st];

        int mid = (st + end) / 2;
        if (nums[mid] > nums[st]) return findMin(nums, mid+1, end);
        else return findMin(nums, st, mid);
    }
}