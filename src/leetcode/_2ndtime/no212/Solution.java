package leetcode._2ndtime.no212;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    private static class Trie {
        public Trie[] children;
        public String word;

        public void addWord(String word) {
            Trie cur = this;
            for (int i = 0; i < word.length(); i++) {
                int pos = word.charAt(i) - 'a';
                if (cur.children == null)
                    cur.children = new Trie[26];

                if (cur.children[pos] == null)
                    cur.children[pos] = new Trie();
                cur = cur.children[pos];
            }
            cur.word = word;
        }
    }

    private char[][] board;
    private int r, c;
    private List<String> res;
    private Trie root;
    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || (r = board.length) == 0 ||
                board[0] == null || (c = board[0].length) == 0)
            return Collections.emptyList();

        this.board = board;
        res = new ArrayList<>();
        root = new Trie();
        for (String w : words) {
            root.addWord(w);
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                visit(i, j, root);
            }
        }

        return res;
    }

    private void visit(int i, int j, Trie node) {
        char ch;
        Trie next;
        if (i < 0 || i >= r || j < 0 || j >= c ||
                (ch=board[i][j]) == '.' ||
                node == null || node.children == null ||
                (next=node.children[ch-'a']) == null)
            return;

        if (next.word != null) {
            res.add(next.word);
            next.word = null;
        }
        board[i][j] = '.';

        visit(i-1, j, next);
        visit(i+1, j, next);
        visit(i, j-1, next);
        visit(i, j+1, next);

        board[i][j] = ch;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        char[][] board = new char[][]{
                "oaan".toCharArray(),
                "etae".toCharArray(),
                "ihkr".toCharArray(),
                "iflv".toCharArray(),
        };
        String[] words = new String[]{"oath","pea","eat","rain"};

        System.out.println(sol.findWords(board, words));
    }
}