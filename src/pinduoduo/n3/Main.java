package pinduoduo.n3;

import java.util.Arrays;

public class Main {
	public int[][] grid(int n) {
		if (n <= 0) return null;

		int[][] m = new int[n][n];
		int i = 0, j = 0, cur = 2;
		m[0][0] = 1;
		while (cur <= n * n) {
			while (j + 1 < n && m[i][j+1] == 0) {
				j++;
				m[i][j] = cur++;
			}
			while (i + 1 < n && m[i+1][j] == 0) {
				i++;
				m[i][j] = cur++;
			}
			while (j - 1 >= 0 && m[i][j-1] == 0) {
				j--;
				m[i][j] = cur++;
			}
			while (i - 1 >= 0 && m[i-1][j] == 0) {
				i--;
				m[i][j] = cur++;
			}
		}
		return m;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(new Main().grid(4)));
	}
}
