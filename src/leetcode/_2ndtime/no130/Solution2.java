package leetcode._2ndtime.no130;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Whiteboard coding!
 * Using Union-Find, not so fast though.
 */
public class Solution2 {
	private char[][] board;
	private int row, col;
	private static Queue<Integer> rList = new LinkedList<>(),
			cList = new LinkedList<>();

	public void solve(char[][] board) {
		if (board == null || board.length == 0 || board[0] == null || board[0].length == 0)
			return;
		this.board = board;
		row = board.length;
		col = board[0].length;
		for (int i = 0; i < row; i++) {
			bfs(i, 0);
			bfs(i, col-1);
		}
		for (int i = 0; i < col; i++) {
			bfs(0, i);
			bfs(row-1, i);
		}

		for (char[] line : board) {
			for (int i = 0; i < col; i++) {
				if (line[i] == 'M')
					line[i] = 'O';
				else if (line[i] == 'O')
					line[i] = 'X';
			}
		}
	}

	private void checkAndAdd(int r, int c) {
		if (r < 0 || r >= row || c < 0 || c >= col || board[r][c] != 'O')
			return ;
		rList.add(r);
		cList.add(c);
	}

	private void bfs(int r, int c) {
		rList.clear();
		cList.clear();

		checkAndAdd(r, c);

		while (!rList.isEmpty()) {
			r = rList.poll();
			c = cList.poll();
			board[r][c] = 'M';
			checkAndAdd(r-1, c);
			checkAndAdd(r+1, c);
			checkAndAdd(r, c-1);
			checkAndAdd(r, c+1);
		}
	}

	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		char[][] board = new char[][] {
				"OOO".toCharArray(),
				"OOO".toCharArray(),
				"OOO".toCharArray(),
		};

		sol.solve(board);
	}
}