package leetcode._1sttime.no081;

/**
 * Created by zkf on 12/31/15.
 */
public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null)
            return false;
        return  (search(nums, target, 0, nums.length) != -1);
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
        if (nums[start] == nums[mid] && nums[mid] == nums[end-1]){
            int tmp = search(nums, target, start, mid);
            return (tmp != -1) ? tmp : search(nums, target, mid, end);
        }


        if (nums[start] <= nums[mid] && nums[mid] <= nums[end-1]){
            if (target < nums[start] || target > nums[end-1])
                return -1;
            if (target < nums[mid])
                return search(nums, target, start, mid);
            else
                return search(nums, target, mid, end);
        } else if (nums[mid] <= nums[end-1] && nums[end-1] <= nums[start]){
            if (target < nums[mid])
                return search(nums, target, start, mid);
            if (target < nums[start])
                return search(nums, target, mid, end);
            else
                return search(nums, target, start, mid);
        } else if (nums[end-1] <= nums[start] && nums[start] <= nums[mid]){
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
        int[] nums = new int[]{1,3,1,1};
        System.out.println(new Solution().search(nums, 3));
    }
}