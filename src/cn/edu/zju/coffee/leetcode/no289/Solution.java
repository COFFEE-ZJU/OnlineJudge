package cn.edu.zju.coffee.leetcode.no289;

public class Solution {
    private int[][] board;
    private int r,c;
    public void gameOfLife(int[][] board) {
        if (board == null || (r=board.length) == 0 ||
                board[0] == null || (c=board[0].length) == 0)
            return;

        this.board = board;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int lc = liveCnt(i,j);
                if (board[i][j] == 1) {
                    if (lc < 2 || lc > 3) board[i][j] = 2;
                }
                else {
                    if (lc == 3) board[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 2) board[i][j] = 0;
                else if (board[i][j] == -1) board[i][j] = 1;
            }
        }
    }

    private int liveCnt(int i, int j) {
        int lc = 0;
        lc += isLive(i-1, j);
        lc += isLive(i+1, j);
        lc += isLive(i, j-1);
        lc += isLive(i, j+1);
        lc += isLive(i-1, j-1);
        lc += isLive(i-1, j+1);
        lc += isLive(i+1, j-1);
        lc += isLive(i+1, j+1);
        return lc;
    }

    private int isLive(int i, int j) {
        if (i < 0 || i >= r || j < 0 || j >=c)
            return 0;

        return board[i][j] >= 1 ? 1 : 0;
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        sol.gameOfLife(new int[][]{new int[]{1}});
    }
}
