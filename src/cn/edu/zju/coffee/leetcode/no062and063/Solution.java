package cn.edu.zju.coffee.leetcode.no062and063;

public class Solution {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0)
			return 0;

		int n = obstacleGrid.length, m = obstacleGrid[0].length;
		if (m == 0)
			return 0;

		if (obstacleGrid[0][0] == 1 || obstacleGrid[n-1][m-1] == 1)
			return 0;

		int[][] dp = new int[n+1][m+1];
		dp[1][1] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i == 0 && j == 0)
					continue;

				if (obstacleGrid[i][j] == 1)
					dp[i+1][j+1] = 0;
				else
					dp[i+1][j+1] = dp[i][j+1] + dp[i+1][j];
			}
		}

		return dp[n][m];
	}

	public int uniquePaths(int m, int n) {
		int total = m + n -2;
		int big, small;
		if (m > n){
			big = m - 1;
			small = n - 1;
		}
		else {
			big = n - 1;
			small = m - 1;
		}
		long res = 1;
		for (int i = big + 1; i <= total; i++)
			res *= i;
		for (int i = small; i >= 1; i--)
			res /= i;

		return (int)res;
	}

    public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] grid = new int[][]{
				new int[]{0,0,0},
				new int[]{0,1,0},
				new int[]{0,0,0},
		};
		System.out.println(sol.uniquePaths(1,10));
		System.out.println(sol.uniquePathsWithObstacles(grid));
	}
}