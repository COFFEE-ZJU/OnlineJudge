package cn.edu.zju.coffee.leetcode.no130;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	char[][] board;
	int r, c;

	public void solve(char[][] board) {
		if (board == null || board.length == 0 ||
				board[0] == null || board[0].length == 0)
			return;

		this.board = board;
		r = board.length; c = board[0].length;
		for (int i = 0; i < r; i++) {
			mark(i, 0);
			mark(i, c-1);
		}
		for (int j = 0; j < c; j++) {
			mark(0, j);
			mark(r-1, j);
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (board[i][j] == 'O' + 1)
					board[i][j] = 'O';
				else if (board[i][j] == 'O')
					board[i][j] = 'X';
			}
		}
	}

	private void mark(int i, int j){
		if (i < 0 || i >= r || j < 0 || j >= c)
			return;
		if (board[i][j] != 'O')
			return;

		List<int[]> list = new LinkedList<>();
		list.add(new int[]{i,j});
		while (!list.isEmpty()){
			int[] pos = list.remove(0);
			int ii = pos[0], jj = pos[1];

			if (ii < 0 || ii >= r || jj < 0 || jj >= c)
				continue;
			if (board[ii][jj] != 'O')
				continue;
			board[ii][jj]++;
			list.add(new int[]{ii-1, jj});
			list.add(new int[]{ii+1, jj});
			list.add(new int[]{ii, jj-1});
			list.add(new int[]{ii, jj+1});
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
	}
}