package leetcode.no238;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;

        int[] nn = new int[nums.length];
        int cur = 1;
        for (int i = 0; i < nn.length; i++) {
            cur *= nums[i];
            nn[i] = cur;
        }

        cur = 1;
        for (int i = nn.length-1; i > 0 ; i--) {
            nn[i] = nn[i-1] * cur;
            cur *= nums[i];
        }
        nn[0] = cur;

        return nn;
    }

    public static void main(String[] args) {
		Solution sol = new Solution();

    }
}
