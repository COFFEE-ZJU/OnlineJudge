package leetcode.no033;

/**
 * Created by zkf on 12/31/15.
 */
public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null)
            return -1;
        return search(nums, target, 0, nums.length);
    }

    private int search(int[] nums, int target, int start, int end){
        if (start >= end)
            return -1;

        if (start + 2 >= end) {
            if (nums[start] == target) return start;
            if (start + 1 < end && nums[start + 1] == target) return start + 1;

            return -1;
        }

        int mid = (start + end) / 2;

        if (nums[start] < nums[mid] && nums[mid] < nums[end-1]){
            if (target < nums[start] || target > nums[end-1])
                return -1;
            if (target < nums[mid])
                return search(nums, target, start, mid);
            else
                return search(nums, target, mid, end);
        } else if (nums[mid] < nums[end-1] && nums[end-1] < nums[start]){
            if (target < nums[mid])
                return search(nums, target, start, mid);
            if (target < nums[start])
                return search(nums, target, mid, end);
            else
                return search(nums, target, start, mid);
        } else if (nums[end-1] < nums[start] && nums[start] < nums[mid]){
            if (target < nums[start])
                return search(nums, target, mid, end);
            if (target < nums[mid])
                return search(nums, target, start, mid);
            else
                return search(nums, target, mid, end);
        } else
            throw new IllegalStateException();

    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(new Solution().search(nums, -1));
    }
}