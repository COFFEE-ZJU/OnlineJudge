package leetcode._2ndtime.no330;

/**
 * Whiteboard coding!
 */
public class Solution {
    public int minPatches(int[] nums, int n) {
        long expect = 1, curMax = 0;
        int patch = 0;
        for (int cur : nums) {
            while (cur > expect && curMax < n) {
                patch++;
                curMax += expect;
                expect = curMax+1;
            }

            if (curMax >= n) return patch;
            curMax += cur;
            expect = curMax+1;
        }
        while (curMax < n) {
            patch++;
            curMax += expect;
            expect = curMax+1;
        }
        return patch;
    }
}