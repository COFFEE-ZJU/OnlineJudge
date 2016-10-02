package leetcode._2ndtime.no410;

import java.util.Arrays;

/**
 * Whiteboard coding!
 */

public class Solution {
    public int splitArray(int[] nums, int m) {
        int len;
        if (nums == null || (len = nums.length) < m) return 0;
        long[] sums = new long[len];
        long sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            sums[i] = sum;
        }

        long maxL = 0, maxR = 0;
        long lPrev = 0, rPrev = 0;
        for (int i = 1; i < m; i++) {
            long avg = sum * i / m;
            int pos = Arrays.binarySearch(sums, avg);
            int lPos, rPos;
            if (pos >= 0) {
                lPos = pos;
                rPos = pos+1;
            } else {
                rPos = -pos-1;
                lPos = rPos-1;
            }
            if (lPos < 0) lPos = 0;
            if (rPos >= len) rPos = len-1;
            long cand1 = Math.max(maxL, sums[lPos] - lPrev);
            long cand2 = Math.max(maxR, sums[lPos] - rPrev);
            maxL = Math.min(cand1, cand2);

            cand1 = Math.max(maxR, sums[rPos] - rPrev);
            cand2 = Math.max(maxL, sums[rPos] - lPrev);
            maxR = Math.min(cand1, cand2);
            lPrev = sums[lPos];
            rPrev = sums[rPos];
        }
        maxL = Math.max(maxL, sums[len-1] - lPrev);
        maxR = Math.max(maxR, sums[len-1] - rPrev);
        return (int)Math.min(maxL, maxR);
    }

    public static void main(String[] args) {
        new Solution().splitArray(new int[]{10,5,13,4,8,4,5,11,14,9,16,10,20,8}, 8);
    }
}