package leetcode._2ndtime.no215;

/**
 * Whiteboard coding!
 */
public class Solution {
    private int findK(int[] nums, int k, int st, int end) {
        int l = st, r = end;
        int key = nums[l];
        while (l < r) {
            while (l < r && nums[r] <= key)
                r--;
            nums[l] = nums[r];
            while (l < r && nums[l] >= key)
                l++;
            nums[r] = nums[l];
        }

        nums[l] = key;
        if (l > k)
            return findK(nums, k, st, l-1);
        else if (l < k)
            return findK(nums, k, l+1, end);
        else return key;

    }

    public int findKthLargest(int[] nums, int k) {
        return findK(nums, k-1, 0, nums.length-1);
    }
}
