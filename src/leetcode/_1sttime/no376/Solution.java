package leetcode._1sttime.no376;

/**
 * Whiteboard coding!
 */
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        int len = 0;
        if (nums == null || (len=nums.length) < 2) return len;

        int iLen = 1, iMax = nums[0];
        int dLen = 1, dMin = nums[0];
        for (int i = 0; i < len; i++) {
            int cur = nums[i];
            if (cur > dMin) {
                if (dLen + 1 > iLen) {
                    iLen = dLen + 1;
                    iMax = cur;
                    continue;
                } else if (cur > iMax) {
                    iMax = cur;
                    continue;
                }
            }
            if (cur < iMax) {
                if (iLen + 1 > dLen) {
                    dLen = iLen + 1;
                    dMin = cur;
                } else if (cur < dMin) {
                    dMin = cur;
                }
            }
        }

        return Math.max(iLen, dLen);
    }
}