package leetcode.no169;

public class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new IllegalArgumentException();

        int cand = nums[0], vote = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == cand)
                vote++;
            else if (vote > 0)
                vote--;
            else {
                cand = nums[i];
                vote = 1;
            }
        }

        return cand;
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
    }
}
