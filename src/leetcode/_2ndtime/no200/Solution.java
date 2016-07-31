package leetcode._2ndtime.no200;

public class Solution {
	private int[] ids;
	private int r, c;
	private int size;
	private char[][] grid;

	public int numIslands(char[][] grid) {
		if (grid == null || (r=grid.length) == 0 || grid[0] == null || (c=grid[0].length) == 0)
			return 0;
		this.grid = grid;
		size = 0;
		ids = new int[r*c];
		for (int i = 0; i < r*c; i++)
			ids[i] = i;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				int id = i*c+j;
				if (grid[i][j] == '0') continue;

				size++;
				if (i != 0 && grid[i-1][j] == '1')
					union(id, id-c);
				if (j != 0 && grid[i][j-1] == '1')
					union(id, id-1);
			}
		}

		return size;
	}

	private void union(int a, int b) {
		int ra = findRoot(a), rb = findRoot(b);
		if (ra == rb) return;
		ids[ra] = rb;
		size--;
	}

	private int findRoot(int id) {
		while (ids[id] != id) {
			id = ids[id];
		}
		return id;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.numIslands(new char[][]{
                "1".toCharArray(),
                "1".toCharArray(),
        }));
	}
}