package leetcode._2ndtime.no162;

/**
 * Whiteboard coding!
 */
public class Solution {
    private int len;
    private int[] ns;
    public int findPeakElement(int[] nums) {
        if (nums == null || (len=nums.length) == 0) return -1;
        ns = nums;
        return findPeekIdx(0, len-1);
    }

    private int findPeekIdx(int st, int end) {
        int mid = (st + end) / 2;
        int cur = ns[mid];
        int left = mid == 0 ? Integer.MIN_VALUE : ns[mid-1];
        int right = mid == len-1 ? Integer.MIN_VALUE : ns[mid+1];
        if (cur >= left && cur >= right) return mid;

        if (left > cur) return findPeekIdx(st, mid-1);
        else return findPeekIdx(mid+1, end);
    }
}