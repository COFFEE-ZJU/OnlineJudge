package leetcode.no327;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int len = nums.length;
        int cnt = 0;
        int[] sums = Arrays.copyOf(nums, len);

        for (int i = 0; i < len; i++) {
            if (i > 0)
                sums[i] += sums[i-1];
            if (sums[i] >= lower && sums[i] <= upper) cnt++;
        }

        Arrays.sort(sums);
        TreeMap<Long, Integer> posMap = new TreeMap<>();
        for (int i = len-1; i >= 0; i--) {
            posMap.put((long)sums[i], i+1);
        }

        int[] bit = new int[len+1];
        for (int i = 0; i < len; i++) {
            Map.Entry<Long, Integer> left = posMap.ceilingEntry((long)sums[i] - (long)upper),
                    right = posMap.floorEntry((long)sums[i] - (long)lower);
            if (left == null || right == null)
                continue;

            cnt += (read(bit, right.getValue()) - read(bit, left.getValue()-1));
            update(bit, i+1, 1);
        }

        return cnt;
    }

    private void update(int[] bit, int idx, int diff) {
        int max = bit.length;
        while (idx < max) {
            bit[idx] += diff;
            idx += (idx & -idx);
        }
    }

    private int read(int[] bit, Integer idx) {
        int sum = 0, max = bit.length;
        while (idx > 0) {
            sum += bit[idx];
            idx -= (idx & -idx);
        }
        return sum;
    }



    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.countRangeSum(new int[]{-2, 5, -1}, -2,2));
        System.out.println(sol.countRangeSum(new int[]{-2, 5, -1}, -2,1));
        System.out.println(sol.countRangeSum(new int[]{0}, 0, 0));
        System.out.println(sol.countRangeSum(new int[]{2147483647,-2147483648,-1,0}, -1, 0));
    }
}
