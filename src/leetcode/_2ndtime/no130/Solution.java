package leetcode._2ndtime.no130;

/**
 * Whiteboard coding!
 * Using Union-Find, not so fast though.
 */
public class Solution {
	char[][] board;
	int r, c;

	int[] id, size;

	private int find(int idx) {
		while (idx != id[idx]) {
			id[idx] = id[id[idx]];
			idx = id[idx];
		}

		return idx;
	}

	private void union(int idx1, int idx2) {
		int id1 = find(idx1), id2 = find(idx2);
		if (id1 == id2) return;

		if (id2 == r*c) {
			id[id1] = id2;
			size[id2] += size[id1];
		}
		else {
			id[id2] = id1;
			size[id1] += size[id2];
		}
	}

	private void unionNeighbors(int i, int j) {
		if (board[i][j] == 'X') return;

		int idx = i*c+j;
		if (i != 0 && board[i-1][j] == 'O')
			union(idx, idx - c);
		if (j != 0 && board[i][j-1] == 'O')
			union(idx, idx - 1);
		if (i != r-1 && board[i+1][j] == 'O')
			union(idx, idx + c);
		if (j != c-1 && board[i][j+1] == 'O')
			union(idx, idx + 1);
	}

	public void solve(char[][] board) {
		if (board == null || board.length == 0 ||
				board[0] == null || board[0].length == 0)
			return;

		this.board = board;
		r = board.length; c = board[0].length;

		id = new int[r*c+1];
		size = new int[r*c+1];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				int idx = i * c + j;
				if (i == 0 || j == 0 || i == r-1 || j == c-1)
					id[idx] = r*c;
				else
					id[idx] = idx;
				size[idx] = 1;
			}
		}
		id[r*c] = r*c;
		size[r*c] = 1;

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				unionNeighbors(i, j);
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (board[i][j] == 'O' && find(i*c+j) != r*c)
					board[i][j] = 'X';
			}
		}

	}

	public static void main(String[] args) {
		Solution sol = new Solution();
	}
}