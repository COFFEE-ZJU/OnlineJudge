package leetcode._1sttime.no079;

public class Solution {
    private boolean[][] flag;
    private char[][] board;
    private char[] wchar;

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0)
            return true;
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0)
            return false;

        wchar = word.toCharArray();
        this.board = board;
        this.flag = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(0, i, j))
                    return true;
            }
        }

        return false;
    }

    public boolean exist(int idx, int r, int c) {
        if (idx == wchar.length)
            return true;

        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length)
            return false;
        if (flag[r][c] || board[r][c] != wchar[idx])
            return false;
        flag[r][c] = true;

        if (exist(idx + 1, r, c - 1) ||
                exist(idx + 1, r, c + 1) ||
                exist(idx + 1, r - 1, c) ||
                exist(idx + 1, r + 1, c))
            return true;

        flag[r][c] = false;
        return false;
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        char[][] board = new char[][]{
                new char[]{'a', 'b', 'c', 'e'},
                new char[]{'s', 'f', 'c', 's'},
                new char[]{'a', 'd', 'e', 'e'},
        };
        System.out.println(sol.exist(board, "abcced"));
        System.out.println(sol.exist(board, "see"));
        System.out.println(sol.exist(board, "abcb"));
    }
}