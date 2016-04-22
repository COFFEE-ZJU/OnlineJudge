package leetcode._2ndtime.no315;

import java.util.*;

/**
 * Whiteboard coding!
 */
public class Solution {
    private void update(int[] bit, int idx, int diff) {
        int max = bit.length;
        while (idx < max) {
            bit[idx] += diff;
            idx += (idx & -idx);
        }
    }

    private int read(int[] bit, int idx) {
        int max = bit.length;
        int sum = 0;
        while (idx > 0) {
            sum += bit[idx];
            idx -= (idx & -idx);
        }
        return sum;
    }

    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        int[] sort = Arrays.copyOf(nums, len+1);
        sort[len] = Integer.MAX_VALUE;
        Arrays.sort(sort);
        Map<Integer, Integer> posMap = new HashMap<>();
        for (int i = len-1; i >= 0; i--) {
            posMap.put(sort[i], i+1);
        }

        int[] bit = sort;
        Arrays.fill(bit, 0);

        List<Integer> res = new LinkedList<>();
        for (int i = len-1; i >= 0; i--) {
            int pos = posMap.get(nums[i]);
            res.add(0, read(bit, pos-1));
            update(bit, pos, 1);
        }

        return res;
    }
}

