package leetcode.no212;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private boolean[][] flag;
    private char[][] board;
    private char[] wchar;

    public List<String> findWords(char[][] board, String[] words) {
        if (words == null || words.length == 0)
            return Collections.emptyList();
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0)
            return Collections.emptyList();

        this.board = board;
        this.flag = new boolean[board.length][board[0].length];
        List<int[]>[] poses = new List[26];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                List<int[]> list = poses[board[i][j] - 'a'];
                if (list == null) {
                    list = new LinkedList<>();
                    poses[board[i][j] - 'a'] = list;
                }
                list.add(new int[]{i, j});
            }
        }

        List<String> ret = new LinkedList<>();
        for (String word : words) {
            wchar = word.toCharArray();
            List<int[]> list = poses[wchar[0] - 'a'];
            if (list == null) continue;
            for (int[] pos : list)
                if (exist(0, pos[0], pos[1]))
                    ret.add(word);
        }

        return ret;
    }

    private boolean exist(int idx, int r, int c) {
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
                exist(idx + 1, r + 1, c)) {
            flag[r][c] = false;
            return true;
        }

        flag[r][c] = false;
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
    }
}