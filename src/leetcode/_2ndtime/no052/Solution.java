package leetcode._2ndtime.no052;

import java.util.Arrays;

/**
 * Whiteboard coding!
 */
public class Solution {
    private char[][] board;
    private int cnt;
    private int n;

    public int totalNQueens(int n) {
        if (n <= 0) return 0;

        this.n = n;
        init();
        solve(0);
        return cnt;
    }

    private void solve(int r) {
        if (r == n) {
            addSolution();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isLegit(r, i)) continue;
            board[r][i] = 'Q';
            solve(r + 1);
            board[r][i] = '.';
        }
    }

    private boolean isLegit(int r, int c) {
        for (int i = 0; i < r; i++) {
            int cLeft = c - r + i, cRight = c + r - i;
            if (board[i][c] == 'Q' ||
                    cLeft >= 0 && board[i][cLeft] == 'Q' ||
                    cRight < n && board[i][cRight] == 'Q')
                return false;
        }
        return true;
    }

    private void addSolution() {
        cnt++;
    }

    private void init() {
        board = new char[n][n];
        for (char[] line : board) {
            Arrays.fill(line, '.');
        }

        cnt = 0;
    }
}