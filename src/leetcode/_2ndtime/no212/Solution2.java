package leetcode._2ndtime.no212;

import leetcode.Trie;

import java.util.*;

public class Solution2 {

    private boolean[][] flag;
    private char[][] board;
    private char[] wchar;
    private Trie root;
    private Set<String> resList;

    public List<String> findWords(char[][] board, String[] words) {
        if (words == null || words.length == 0)
            return Collections.emptyList();
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0)
            return Collections.emptyList();

        root = new Trie();
        this.board = board;
        this.flag = new boolean[board.length][board[0].length];

        for (String w : words) {
            root.addWord(w);
        }

        resList = new HashSet<>();

        List<int[]>[] poses = new List[26];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                findWord(root, i,j);
            }
        }

        return new ArrayList<>(resList);
    }

    private void findWord(Trie cur, int r, int c) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length)
            return ;
        if (flag[r][c])
            return ;
        int pos = board[r][c] - 'a';

        Trie child = cur.children[pos];
        if (child == null)
            return ;

        if (child.word != null)
            resList.add(child.word);

        flag[r][c] = true;
        findWord(child, r-1, c);
        findWord(child, r+1, c);
        findWord(child, r, c-1);
        findWord(child, r, c+1);
        flag[r][c] = false;
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
    }
}