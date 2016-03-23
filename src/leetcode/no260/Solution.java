package leetcode.no260;

public class Solution {
    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length < 2) return null;

        int xor = 0;
        for (int n : nums) xor ^= n;
        int lowbit = xor & (-xor);
        int a=0, b=0;
        for (int n : nums){
            if ((n & lowbit) == 0) a ^= n;
            else b ^= n;
        }

        return new int[]{a, b};
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
    }
}
