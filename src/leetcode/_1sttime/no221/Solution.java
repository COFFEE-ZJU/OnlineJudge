package leetcode._1sttime.no221;

public class Solution {
    public int maximalSquare(char[][] matrix) {
        int r,c;
        if (matrix == null || (r=matrix.length) == 0 ||
                matrix[0] == null || (c=matrix[0].length) == 0)
            return 0;

        int[][] dp = new int[r+1][c+1];
        int max = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == '0')
                    continue;
                int cur = Math.min(dp[i][j], Math.min(dp[i+1][j], dp[i][j+1])) + 1;
                if (cur > max) max = cur;
                dp[i+1][j+1] = cur;
            }
        }

        return max*max;
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
    }
}
