package hiho.no1240;

import java.util.Scanner;

public class Main {
	private static int[][] mat1, mat2;

	private static int[] relPos(int oriR, int oriC, int n, int dir) {
		switch (dir) {
			case 0: return new int[]{oriR, oriC};
			case 1: return new int[]{oriC, n-1-oriR};
			case 2: return new int[]{n-1-oriR, n-1-oriC};
			case 3: return new int[]{n-1-oriC ,oriR};
		}

		return null;
	}

	private static int xor(int[][] mat, int r, int c, int n) {
		int xor = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				xor ^= mat[r+i][c+j];
			}
		}

		return xor;
	}

	public static boolean solve(int r1, int c1, int r2, int c2, int n) {
		if (n % 2 == 1) {
			for (int d = 0; d < 4; d++) {
				boolean ok = true;
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						int[] ij = relPos(i, j, n, d);
						if (mat1[r1+i][c1+j] != mat2[r2+ij[0]][c2+ij[1]]) {
							ok = false;
							break;
						}
					}
					if (!ok)
						break;
				}
				if (ok)
					return ok;
			}

			return false;
		}

		n /= 2;
//		int xor10 = xor(mat1, r1, c1, n),
//				xor11 = xor(mat1, r1, c1+n, n),
//				xor12 = xor(mat1, r1+n, c1+n, n),
//				xor13 = xor(mat1, r1+n, c1, n);
//		int xor20 = xor(mat2, r2, c2, n),
//				xor21 = xor(mat2, r2, c2+n, n),
//				xor22 = xor(mat2, r2+n, c2+n, n),
//				xor23 = xor(mat2, r2+n, c2, n);
//
//		if (xor10 == xor20 && xor11 == xor21 && xor12 == xor22 && xor13 == xor23) {
//			if (solve(r1, c1, r2, c2, n) && solve(r1, c1+n, r2, c2+n, n) &&
//					solve(r1+n, c1+n, r2+n, c2+n, n) && solve(r1+n, c1, r2+n, c2, n))
//				return true;
//		}
//
//		if (xor10 == xor21 && xor11 == xor22 && xor12 == xor23 && xor13 == xor20) {
//			if (solve(r1, c1, r2, c2+n, n) && solve(r1, c1+n, r2+n, c2+n, n) &&
//					solve(r1+n, c1+n, r2+n, c2, n) && solve(r1+n, c1, r2, c2, n))
//				return true;
//		}
//
//		if (xor10 == xor22 && xor11 == xor23 && xor12 == xor20 && xor13 == xor21) {
//			if (solve(r1, c1, r2+n, c2+n, n) && solve(r1, c1+n, r2+n, c2, n) &&
//					solve(r1+n, c1+n, r2, c2, n) && solve(r1+n, c1, r2, c2+n, n))
//				return true;
//		}
//
//		if (xor10 == xor23 && xor11 == xor20 && xor12 == xor21 && xor13 == xor22) {
//			if (solve(r1, c1, r2+n, c2, n) && solve(r1, c1+n, r2, c2, n) &&
//					solve(r1+n, c1+n, r2, c2+n, n) && solve(r1+n, c1, r2+n, c2+n, n))
//				return true;
//		}

		if (solve(r1, c1, r2, c2, n) && solve(r1, c1+n, r2, c2+n, n) &&
				solve(r1+n, c1+n, r2+n, c2+n, n) && solve(r1+n, c1, r2+n, c2, n))
			return true;
		if (solve(r1, c1, r2, c2+n, n) && solve(r1, c1+n, r2+n, c2+n, n) &&
				solve(r1+n, c1+n, r2+n, c2, n) && solve(r1+n, c1, r2, c2, n))
			return true;
		if (solve(r1, c1, r2+n, c2+n, n) && solve(r1, c1+n, r2+n, c2, n) &&
				solve(r1+n, c1+n, r2, c2, n) && solve(r1+n, c1, r2, c2+n, n))
			return true;
		if (solve(r1, c1, r2+n, c2, n) && solve(r1, c1+n, r2, c2, n) &&
				solve(r1+n, c1+n, r2, c2+n, n) && solve(r1+n, c1, r2+n, c2+n, n))
			return true;

		return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {
			int r = scanner.nextInt();
			for (int rr = 0; rr < r; rr++) {
				int n = scanner.nextInt();
				mat1 = new int[n][n];
				mat2 = new int[n][n];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						mat1[i][j] = scanner.nextInt();
					}
				}
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						mat2[i][j] = scanner.nextInt();
					}
				}

				System.out.println(solve(0,0, 0,0, n) ? "YES" : "NO" );
			}
		}
	}
}
