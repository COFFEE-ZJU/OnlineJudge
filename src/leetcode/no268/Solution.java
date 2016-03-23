package leetcode.no268;

public class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= (i+1);
            xor ^= nums[i];
        }

        return xor;
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.missingNumber(new int[]{0,3,1}));
    }
}
