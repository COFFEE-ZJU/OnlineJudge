package hiho.netease.n1;

import java.util.Scanner;

/**
 * 
 * Problem Description: http://hihocoder.com/contest/msinterntest/problem/1
 * @author zkf
 *
 */

public class Main {
	private int[][] mat = new int[100][100],
					mat2 = new int[100][100];
	private int n,m;

	private void type1() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				mat2[j][n-1-i] = mat[i][j];
			}
		}

		int[][] tmp = mat;
		mat = mat2;
		mat2 = tmp;
		int t = n;
		n = m;
		m = t;
	}

	private void type2() {
		int t = n;
		n = m;
		m = t;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				mat2[i][j] = mat[j][n-1-i];
			}
		}

		int[][] tmp = mat;
		mat = mat2;
		mat2 = tmp;
	}

	private void type3() {
		for (int j = 0; j < m; j++) {
			for (int i = 0; i < n / 2; i++) {
				int t = mat[i][j];
				mat[i][j] = mat[n-1-i][j];
				mat[n-1-i][j] = t;
			}
		}
	}

	private void type4() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m / 2; j++) {
				int t = mat[i][j];
				mat[i][j] = mat[i][m-1-j];
				mat[i][m-1-j] = t;
			}
		}
	}

	private void type56(int x0, int y0, int x1, int y1, int diff) {
		for (int i = x0; i <= x1; i++) {
			for (int j = y0; j <= y1; j++) {
				mat[i][j] += diff;
				if (mat[i][j] < 0) mat[i][j] = 0;
				if (mat[i][j] > 255) mat[i][j] = 255;
			}
		}
	}

	private void type7(int x0, int y0, int x1, int y1) {
		n = x1 - x0 + 1;
		m = y1 - y0 + 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				mat2[i][j] = mat[x0+i][y0+j];
			}
		}
		int[][] tmp = mat;
		mat = mat2;
		mat2 = tmp;
	}

	public void deal() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {
			int r = scanner.nextInt();
			for (int rr = 0; rr < r; rr++) {
				n = scanner.nextInt();
				m = scanner.nextInt();
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						mat[i][j] = scanner.nextInt();
					}
				}

				int t = scanner.nextInt();
				for (int tt = 0; tt < t; tt++) {
					int type = scanner.nextInt();
					switch (type) {
						case 1:
							type1();
							break;
						case 2:
							type2();
							break;
						case 3:
							type3();
							break;
						case 4:
							type4();
							break;
						case 5:
							type56(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(),
									scanner.nextInt());
							break;
						case 6:
							type56(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(),
									-scanner.nextInt());
							break;
						case 7:
							type7(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
							break;
					}
					printAll();
				}

				printStatus();
			}
		}
	}

	private void printAll() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(mat[i][j] + ", ");
			}
			System.out.println();
		}
	}

	private void printStatus() {
		long total = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				total += mat[i][j];
			}
		}

		System.out.println(String.format("%d %d %d %d", n, m, mat[0][0], total));
	}

	public static void main(String[] args) {
		new Main().deal();
	}
}
