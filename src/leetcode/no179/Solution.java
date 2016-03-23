package leetcode.no179;

import java.util.Arrays;

public class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return "";

        int len = nums.length;
        Number[] numbers = new Number[len];
        for (int i = 0; i < len; i++)
            numbers[i] = new Number(nums[i]);

        Arrays.sort(numbers);
        StringBuilder sb = new StringBuilder();
        for (Number n : numbers)
            sb.append(n.num);
        while (sb.charAt(0) == '0' && sb.length() > 1)
            sb.deleteCharAt(0);
        return sb.toString();
    }

    private static class Number implements Comparable<Number>{
        final int num;

        private Number(int num) {
            this.num = num;
        }

        @Override
        public int compareTo(Number o) {
            return (""+o.num+num).compareTo(""+num+o.num);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(sol.largestNumber(new int[]{0, 0}));
    }
}
