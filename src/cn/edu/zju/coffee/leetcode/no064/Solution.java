package cn.edu.zju.coffee.leetcode.no064;

public class Solution {
	public int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int r = grid.length, c = grid[0].length;
		if (c == 0)
			return 0;

		int[][] minSum = new int[r][c];
		minSum[0][0] = grid[0][0];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (i == 0 && j == 0)
					continue;

				if (i == 0)
					minSum[i][j] = minSum[i][j-1] + grid[i][j];
				else if (j == 0)
					minSum[i][j] = minSum[i-1][j] + grid[i][j];
				else
					minSum[i][j] = grid[i][j] + Math.min(minSum[i][j-1], minSum[i-1][j]);

			}
		}

		return minSum[r-1][c-1];
	}

    public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] grid = new int[][]{
				new int[]{0,0,0},
				new int[]{1,1,2},
				new int[]{0,0,0},
		};

		System.out.println(sol.minPathSum(grid));
	}
}