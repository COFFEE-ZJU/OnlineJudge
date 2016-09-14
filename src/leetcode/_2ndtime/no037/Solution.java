package leetcode._2ndtime.no037;

import java.util.Arrays;

/**
 * Whiteboard coding!
 */
public class Solution {
    private char[][] board;
    private boolean solved = false;
    public void solveSudoku(char[][] board) {
        if (board == null) return;

        this.board = board;
        solved = false;
        solve(0, 0);
    }

    private void solve(int i, int j) {
        if (solved) return;
        if (i >= 9) {
            solved = true;
            return;
        }
        if (j >= 9) {
            solve(i + 1, 0);
            return;
        }
        if (board[i][j] != '.') {
            solve(i, j + 1);
            return;
        }

        char[] legit = getLegitChars(i, j);
        for (char c : legit) {
            board[i][j] = c;
            solve(i, j+1);
            if (solved) return;
        }

        board[i][j] = '.';
    }

    private boolean[] isLegit = new boolean[9];
    private char[] getLegitChars(int i, int j) {
        Arrays.fill(isLegit, true);
        for (int ii = 0; ii < 9; ii++) {
            char c = board[ii][j];
            if (c != '.') isLegit[c-'1'] = false;
            c = board[i][ii];
            if (c != '.') isLegit[c-'1'] = false;
        }

        int stI = i / 3 * 3, stJ = j / 3 * 3;
        for (int ii = 0; ii < 3; ii++) {
            for (int jj = 0; jj < 3; jj++) {
                char c = board[stI + ii][stJ + jj];
                if (c != '.') isLegit[c-'1'] = false;
            }
        }

        String str = "";
        for (int ii = 0; ii < 9; ii++) {
            if (isLegit[ii]) str += ""+(char)(ii + '1');
        }
        return str.toCharArray();
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {
                "519748632".toCharArray(),
                "783652419".toCharArray(),
                "426139875".toCharArray(),
                "357986241".toCharArray(),
                "264317598".toCharArray(),
                "198524367".toCharArray(),
                "975863124".toCharArray(),
                "832491756".toCharArray(),
                "64127598.".toCharArray()
        };

        new Solution().solveSudoku(board);
    }
}