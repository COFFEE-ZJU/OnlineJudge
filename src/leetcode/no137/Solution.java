package leetcode.no137;

public class Solution {
	public int singleNumber(int[] nums) {
		int one=0, two=0, three=0;
		for(int n : nums) {
			two |= one&n;
			one ^= n;
			//cout<<one<<endl;
			three = one & two;
			one &= ~three;
			two &= ~three;
		}

		return one;
	}

    public static void main(String[] args) {
		Solution sol = new Solution();
	}
}