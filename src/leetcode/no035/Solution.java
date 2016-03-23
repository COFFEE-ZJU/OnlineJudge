package leetcode.no035;

/**
 * Created by zkf on 12/31/15.
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;
        if (target > nums[nums.length-1])
            return nums.length;
        return search(nums, target, 0, nums.length);
    }

    private int search(int[] nums, int target, int start, int end){
        if (start >= end)
            return -1;

        if (start + 1 == end)
            return start;

        int mid = (start + end) / 2;
        if (target <= nums[mid-1])
            return search(nums, target, start, mid);
        else
            return search(nums, target, mid, end);

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        System.out.println(new Solution().searchInsert(nums, 7));
    }
}