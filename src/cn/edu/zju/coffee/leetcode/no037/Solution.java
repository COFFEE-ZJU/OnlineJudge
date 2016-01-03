package cn.edu.zju.coffee.leetcode.no037;

import java.util.Arrays;

/**
 * Created by Zhangkefei on 2016/1/1.
 */
public class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9)
            return;

        Cell[][] cb = Cell.fromChars(board);


        if (trySolve(cb, 0, 0))
            Cell.fillChars(cb, board);
        else
            throw new IllegalStateException();
    }

    private boolean trySolve(Cell[][] cb, int row, int col){
        if (row >= 9)
            return true;
        if (col >= 9)
            return trySolve(cb, row + 1, 0);

        if (cb[row][col].val != -1)
            return trySolve(cb, row, col+1);

        for(int testVal = 0; testVal < 9; testVal ++){
            cb[row][col].val = testVal;
            if (isValidSudoku(cb, row, col) && trySolve(cb, row, col + 1))
                return true;

            cb[row][col].val = -1;
        }

        return false;
    }

    private boolean isValidSudoku(Cell[][] cb, int i, int j) {
        int val = cb[i][j].val;
        if (val == -1)
            return true;
        for (int k = 0; k < 9; k++) {
            if (cb[i][k].val == val && j != k ||
                    cb[k][j].val == val && k != i)
                return false;
        }

        int rs = i / 3 * 3, cs = j / 3 * 3;
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++)
                if (cb[rs+k][cs+l].val == val && !(rs+k == i && cs+l == j))
                    return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String charStr =
                "53..7...." +
                "6..195..." +
                ".98....6." +
                "8...6...3" +
                "4..8.3..1" +
                "7...2...6" +
                ".6....28." +
                "...419..5" +
                "....8..79";

        char[][] board = Cell.genChars(charStr);
        new Solution().solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    private static class Cell{
        final int row, col;
        int val;
        boolean[] possibles = null;

        private Cell(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
            if(val == -1) {
                possibles = new boolean[9];
                for (int i = 0; i < 9; i++)
                    possibles[i] = true;
            }
        }

        static char[][] genChars(String str){
            char[][] chars = new char[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j <9; j++) {
                    chars[i][j] = str.charAt(i * 9 + j);
                }
            }

            return chars;
        }

        static Cell[][] fromChars(char[][] board){
            Cell[][] ret = new Cell[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    ret[i][j] = new Cell(i, j, (board[i][j] == '.') ? -1 : board[i][j] - '1');
                }
            }

            return ret;
        }

        static void fillChars(Cell[][] cb, char[][] board){
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
//                    if (cb[i][j].val == -1)
//                        throw new IllegalStateException();
                    board[i][j] = (char)(cb[i][j].val + '1');
                }
            }
        }
    }
}
