package leetcode._2ndtime.no033;

import java.util.Arrays;

/**
 * Whiteboard coding!
 */

public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int res = search(nums, 0, nums.length-1, target);
        return res < 0 ? -1 : res;
    }

    private int search(int[] nums, int st, int end, int target) {
        if (st == end) return nums[st] == target ? st : -1;
        if (st+1 == end) {
            if (nums[st] == target) return st;
            if (nums[end] == target) return end;
        }

        if (nums[end] > nums[st]) return Arrays.binarySearch(nums, st, end+1, target);

        int mid = (st + end) / 2;
        if (nums[mid] > nums[st]) {
            if (target >= nums[st] && target <= nums[mid])
                return Arrays.binarySearch(nums, st, mid+1, target);
            else
                return search(nums, mid+1, end, target);
        } else {
            if (target > nums[mid] && target <= nums[end])
                return Arrays.binarySearch(nums, mid+1, end+1, target);
            else
                return search(nums, st, mid, target);
        }
    }
}