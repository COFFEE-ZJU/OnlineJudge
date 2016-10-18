package leetcode._2ndtime.no368;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Whiteboard coding!
 *
 */
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) return Collections.emptyList();

        int[] prevIdx = new int[len];
        int[] prevLen = new int[len];
        Arrays.sort(nums);
        int max = 0, maxIdx = 0;
        for (int i = 1; i < len; i++) {
            int cur = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (cur % nums[j] != 0) continue;
                if (prevLen[i] <= prevLen[j]) {
                    prevLen[i] = prevLen[j] + 1;
                    prevIdx[i] = j;
                    if (prevLen[i] > max) {
                        max = prevLen[i];
                        maxIdx = i;
                    }
                }
            }
        }
        int idx = maxIdx;
        List<Integer> list = new LinkedList<>();
        while (prevLen[idx] != 0) {
            list.add(0, nums[idx]);
            idx = prevIdx[idx];
        }
        list.add(0, nums[idx]);
        return list;
    }
}