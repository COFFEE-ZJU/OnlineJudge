package baidu.n3;

import java.util.Arrays;

public class Main {

	public int[][] calcMatrix(int initialValue, int rows, int columns) {
		if (rows <= 0 || columns <= 0) return null;
		int[][] res = new int[rows][rows];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < rows; j++) {
				res[i][j] = calc(i, j, columns, initialValue);
			}
		}

		return res;
	}

	private int calc(int i, int j, int cols, int init) {
		int st1 = i * cols + init, st2 = j * cols + init;
		int res = 0;
		for (int k = 0; k < cols; k++) {
			res += st1 * st2;
			st1++;
			st2++;
		}
		return res;
	}

	public static void main(String[] args) {
		int[][] res = new Main().calcMatrix(4, 3, 2);
		System.out.println(Arrays.deepToString(res));
	}
}