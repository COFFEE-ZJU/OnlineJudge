package cn.edu.zju.coffee.leetcode.no051and052;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhangkefei on 2016/1/7.
 */
public class Solution {
    private boolean[][] board;
    private List<List<String>> res;
    private boolean onlyCnt;
    private int cnt;
    private int n;

    public int totalNQueens(int n) {
        onlyCnt = true;
        if (n <= 0)
            return 0;

        solve(n);
        return cnt;
    }

    public List<List<String>> solveNQueens(int n) {
        onlyCnt = false;
        res = new ArrayList<>(n);
        if (n <= 0)
            return res;

        solve(n);
        return res;
    }

    public void solve(int n) {
        this.n = n;
        board = new boolean[n][n];
        cnt = 0;
        trySolve(0);
    }

    private void trySolve(int row){
        if (row >= n) {
            addAns();
            return ;
        }

        for (int i = 0; i < n; i++) {
            board[row][i] = true;
            if (isValid(row, i))
                trySolve(row + 1);
            board[row][i] = false;
        }
    }

    private void addAns(){
        cnt ++;
        if (onlyCnt)
            return;

        StringBuilder sb;
        List<String> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < n; j++)
                sb.append(board[i][j] ? 'Q' : '.');

            list.add(sb.toString());
        }

        res.add(list);
    }

    private boolean isValid(int r, int c){
        if (! board[r][c])
            return true;

        int i;
        for (i = 0; i < n; i++) {
            if ((board[i][c] && i != r) || (board[r][i] && i != c))
                return false;
        }

        for (i = 1; ; i ++){
            int cr = r-i, cc = c-i;
            if (cr < 0 || cc < 0)
                break;
            if (board[cr][cc])
                return false;
        }
        for (i = 1; ; i ++){
            int cr = r-i, cc = c+i;
            if (cr < 0 || cc >= n)
                break;
            if (board[cr][cc])
                return false;
        }
        for (i = 1; ; i ++){
            int cr = r+i, cc = c-i;
            if (cr >= n || cc < 0)
                break;
            if (board[cr][cc])
                return false;
        }
        for (i = 1; ; i ++){
            int cr = r+i, cc = c+i;
            if (cr >= n || cc >= n)
                break;
            if (board[cr][cc])
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solveNQueens(4));
    }
}
