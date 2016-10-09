package leetcode.contest08.n2;

public class Solution {
    private boolean legal;
    private int[] nums;
    private int len;
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        long sum = 0;
        for (int n : nums) sum += n;
        if (sum % 2 == 1) return false;

        len = nums.length;
        this.nums = nums;
        legal = false;
        solve(0, sum/2);
        return legal;
    }

    private void solve(int i, long target) {
        if (target == 0) {
            legal = true;
        }
        if (legal || target < 0 || i >= len) return;

        solve(i+1, target-nums[i]);
        solve(i+1, target);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(new Solution().canPartition(new int[]{1, 2, 3, 5}));
    }
}