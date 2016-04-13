package leetcode._2ndtime.no063;

/**
 * Whiteboard coding!
 */
public class Solution {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int r = obstacleGrid.length, c = obstacleGrid[0].length;
		int[][] dp = new int[r+1][c+1];
		dp[1][0] = 1;
		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {
				if (obstacleGrid[i-1][j-1] == 1)
					continue;
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}

		return dp[r][c];
	}
}