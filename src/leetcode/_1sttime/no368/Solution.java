package leetcode._1sttime.no368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Whiteboard coding!
 */
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        if (len == 0) return Collections.emptyList();
        int[] next = new int[len], lens = new int[len];
        Arrays.sort(nums);
        int maxPos = 0, maxLen = 0;
        for (int i = len-2; i >= 0; i--) {
            for (int j = i+1; j < len; j++) {
                if (nums[j] % nums[i] == 0 && lens[j] + 1 > lens[i]) {
                    lens[i] = lens[j] + 1;
                    next[i] = j;
                    if (lens[i] > maxLen) {
                        maxLen = lens[i];
                        maxPos = i;
                    }
                }
            }
        }

        List<Integer> ret = new ArrayList<>(maxLen);
        int idx = maxPos;
        while (idx < next[idx]) {
            ret.add(nums[idx]);
            idx = next[idx];
        }
        ret.add(nums[idx]);

        return ret;
    }
}