package leetcode._2ndtime.no051;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Whiteboard coding!
 */
public class Solution {
    private char[][] board;
    private List<List<String>> res;
    private int n;

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) return Collections.emptyList();

        this.n = n;
        init();
        solve(0);
        return res;
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
        List<String> sol = new ArrayList<>(n);
        for (char[] line : board) {
            sol.add(new String(line));
        }
        res.add(sol);
    }

    private void init() {
        board = new char[n][n];
        for (char[] line : board) {
            Arrays.fill(line, '.');
        }

        res = new ArrayList<>();
    }
}