package leetcode.no069;

public class Solution {
	public int mySqrt(int x) {
		if (x == 0 || x == 1)
			return x;

		int st = 0, end = x;
		while (st + 1 != end){
			int mid = (st + end) / 2;
			long test = (long)mid * (long)mid;
			if (test == x)
				return mid;

			if (test > x)
				end = mid;
			else
				st = mid;
		}

		return st;
	}

    public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.mySqrt(2));
		System.out.println(sol.mySqrt(3));
		System.out.println(sol.mySqrt(4));
		System.out.println(sol.mySqrt(12345*12345+20));
		System.out.println(sol.mySqrt(12345*12345));
		System.out.println(sol.mySqrt(2147483647));
	}
}