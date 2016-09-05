package leetcode._1sttime.no036;

/**
 * Created by Zhangkefei on 2016/1/3.
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        Cell[][] cb = Cell.fromChars(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int val = cb[i][j].val;
                if (val == -1)
                    continue;
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
            }
        }

        return true;
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

        char[][] board = new char[][]{
                "........2".toCharArray(),
                "......6..".toCharArray(),
                "..14..8..".toCharArray(),
                ".........".toCharArray(),
                ".........".toCharArray(),
                "....3....".toCharArray(),
                "5.86.....".toCharArray(),
                ".9....4..".toCharArray(),
                "....5....".toCharArray()};
//        char[][] board = Cell.genChars(charStr);
        System.out.println(new Solution().isValidSudoku(board));
    }
}
