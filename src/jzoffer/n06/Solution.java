package jzoffer.n06;

/**
 * Created by Zhangkefei on 2016/4/23.
 */
public class Solution {
    private int min(int [] nums, int st, int end) {
        if (st > end) return 0;
        if (st == end || nums[end] > nums[st])
            return nums[st];

        int lv = nums[st], rv = nums[end];
        int mid = (st + end) >>> 1;

        if (nums[mid] < lv)
            return min(nums, st, mid);
        else if (nums[mid] > rv)
            return min(nums, mid + 1, end);
        else
            return Math.min(min(nums, st, mid), min(nums, mid + 1, end));
    }

    public int minNumberInRotateArray(int [] array) {
        //if (array == null || array.length == 0) return 0;
        return min(array, 0, array.length-1);
    }
}
