package hiho.netease.n2;

import java.util.Scanner;

/**
 * 
 * Problem Description: http://hihocoder.com/contest/msinterntest/problem/1
 * @author zkf
 *
 */

public class Main {
	private char[][] mat = new char[20][20];
	private int n,m;

	private int swapAndCalc(int x0, int y0, int x1, int y1) {
		char tmp = mat[x0][y0];
		mat[x0][y0] = mat[x1][y1];
		mat[x1][y1] = mat[x0][y0];
		return -1;
	}

	public void deal() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {
			int r = scanner.nextInt();
			for (int rr = 0; rr < r; rr++) {
				n = scanner.nextInt();
				m = scanner.nextInt();
				for (int i = 0; i < n; i++) {
					String line = scanner.next();
					for (int j = 0; j < m; j++) {
						mat[i][j] = line.charAt(j);
					}
				}


			}
		}
	}

	public static void main(String[] args) {
		new Main().deal();
	}
}
