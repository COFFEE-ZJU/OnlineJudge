package leetcode.no026;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int i = 1;
        for (int j = 1, prev = nums[0]; j < nums.length; j++) {
            if (nums[j] == prev) continue;
            nums[i++] = nums[j];
            prev = nums[j];
        }

        return i;
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
    }
}
