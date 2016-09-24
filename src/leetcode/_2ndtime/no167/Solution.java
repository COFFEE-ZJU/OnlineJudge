package leetcode._2ndtime.no167;

import java.util.Arrays;

/**
 * Whiteboard coding!
 */

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int len;
        if (numbers == null || (len = numbers.length) == 0) return null;

        int left = 0, right = len-1;
        while (left < right) {
            int tt = target - numbers[left];
            int idx = Arrays.binarySearch(numbers, left+1, right+1, tt);
            if (idx >= 0) return new int[]{left+1, idx+1};

            right = -idx - 2;
            if (left >= right) break;

            tt = target - numbers[right];
            idx = Arrays.binarySearch(numbers, left, right, tt);
            if (idx >= 0) return new int[]{idx+1, right+1};

            left = -idx - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        new Solution().twoSum(new int[]{5,25,75}, 100);
    }
}