package leetcode.no136;

public class Solution {
	public int singleNumber(int[] nums) {
		int ii = 0;
		for(int n : nums)
			ii ^= n;

		return ii;
	}

    public static void main(String[] args) {
		Solution sol = new Solution();
	}
}