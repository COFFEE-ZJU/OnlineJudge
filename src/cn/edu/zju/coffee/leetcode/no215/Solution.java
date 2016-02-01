package cn.edu.zju.coffee.leetcode.no215;

public class Solution {
    private int[] nums;
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;

        this.nums = nums;

        return findKth(nums.length - k + 1, 0, nums.length-1);
    }

    private int findKth(int k, int st, int end){
        int piviot = nums[end];
        int left = st, right = end;
        while (true){
            while (nums[left] < piviot && left < right)
                left++;
            while (nums[right] >= piviot && left < right)
                right--;
            if (left == right) break;
            swap(left, right);
        }
        swap(left, end);
        if (k == left + 1)
            return piviot;
        else if (k < left + 1)
            return findKth(k, st, left-1);
        else
            return findKth(k, left+1, end);
    }

    private void swap(int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();

    }
}
