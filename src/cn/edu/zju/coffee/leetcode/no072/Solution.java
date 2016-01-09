package cn.edu.zju.coffee.leetcode.no072;

public class Solution {
	public int minDistance(String word1, String word2) {
		if (word1 == word2)
			return 0;
		if (word1 == null || word1.length() == 0)
			return word2.length();
		if (word2 == null || word2.length() == 0)
			return word1.length();

		int r = word1.length(), c = word2.length();
		char[] w1 = word1.toCharArray(), w2 = word2.toCharArray();
		int[][] dp = new int[r+1][c+1];
		for (int i = 0; i <= r; i++)
			dp[i][0] = i;
		for (int i = 0; i <= c; i++)
			dp[0][i] = i;

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (w1[i] == w2[j])
					dp[i+1][j+1] = dp[i][j];
				else
					dp[i+1][j+1] = min(dp[i][j], dp[i][j+1], dp[i+1][j]) + 1;
			}
		}
		return dp[r][c];
	}

	private int min(int a, int b, int c){
		if (a <= b && a <= c)
			return a;
		if (b <= a && b <= c)
			return b;
		return c;
	}

    public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.minDistance("", ""));
		System.out.println(sol.minDistance("", "234"));
		System.out.println(sol.minDistance("234", "234"));
		System.out.println(sol.minDistance("123", "234"));
		System.out.println(sol.minDistance("123", "1234"));
		System.out.println(sol.minDistance("123", "134"));
		System.out.println(sol.minDistance("1235", "134"));
	}
}