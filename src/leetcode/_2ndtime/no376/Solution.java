package leetcode._2ndtime.no376;

/**
 * Whiteboard coding!
 */
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        int len = 0;
        if (nums == null || (len=nums.length) < 2) return len;

        int iLen, dLen, iMax, dMin;
        iLen = dLen = 1;
        iMax = dMin = nums[0];
        for (int n : nums) {
            iMax = Math.max(iMax, n);
            dMin = Math.min(dMin, n);
            if (n > dMin && dLen >= iLen) {
                iLen = dLen + 1;
                iMax = n;
            }
            if (n < iMax && iLen >= dLen) {
                dLen = iLen + 1;
                dMin = n;
            }
        }
        return Math.max(iLen, dLen);
    }
}