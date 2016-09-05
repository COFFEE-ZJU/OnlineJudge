package leetcode._2ndtime.no164;

/**
 * Whiteboard coding!
 */
public class Solution {
    public int maximumGap(int[] nums) {
        int len;
        if (nums == null || (len=nums.length) < 2) return 0;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int n : nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        int range = max - min + 1;
        if (range < 2) return range - 1;
        int slot = range / len;
        if (range % len != 0) slot++;

        int[] mins = new int[len];
        int[] maxs = new int[len];
        for (int n : nums) {
            int idx = (n-min) / slot;
            if (mins[idx] == 0) {
                mins[idx] = n+1;
                maxs[idx] = n+1;
            } else {
                mins[idx] = Math.min(mins[idx], n+1);
                maxs[idx] = Math.max(maxs[idx], n+1);
            }
        }

        int maxGap = 0, prevMax = 0;
        for (int i = 0; i < len; i++) {
            if (prevMax != 0 && mins[i] != 0) {
                maxGap = Math.max(mins[i]-prevMax, maxGap);
            }

            if (maxs[i] != 0){
                prevMax = maxs[i];
            }
        }
        return maxGap;
    }
}