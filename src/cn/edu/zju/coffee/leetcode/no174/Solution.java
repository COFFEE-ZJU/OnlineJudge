package cn.edu.zju.coffee.leetcode.no174;

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int r, c;
        if (dungeon == null || (r = dungeon.length) == 0 ||
                dungeon[0] == null || (c = dungeon[0].length) == 0)
            return 0;

        int[][] dp = new int[r][c];
        dp[r-1][c-1] = 1-dungeon[r-1][c-1];
        if (dp[r-1][c-1] < 1) dp[r-1][c-1] = 1;

        for (int i = c-2; i >= 0 ; i--) {
            int min = dp[r-1][i+1] - dungeon[r-1][i];
            dp[r-1][i] = min < 1 ? 1 : min;
        }
        for (int i = r-2; i >= 0 ; i--) {
            int min = dp[i+1][c-1] - dungeon[i][c-1];
            dp[i][c-1] = min < 1 ? 1 : min;
        }
        for (int i = r-2; i >= 0 ; i--) {
            for (int j = c-2; j >= 0 ; j--) {
                int min = Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j];
                dp[i][j] = min < 1 ? 1 : min;
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
    }
}
