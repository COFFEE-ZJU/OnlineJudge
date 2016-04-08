package hiho.hihointerview5.n3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * Problem Description: http://hihocoder.com/contest/msinterntest/problem/1
 * @author zkf
 *
 */

public class Main {
	public void deal() {
		try(Scanner scanner = new Scanner(System.in)) {
			int[][] ln = new int[51][51];
			int[][] dp = new int[1000][1001];
			while (scanner.hasNextInt()) {
				int r = scanner.nextInt();
				for (int rr = 0; rr < r; rr++) {
					int n = scanner.nextInt(), m = scanner.nextInt(),
							s = scanner.nextInt(), t = scanner.nextInt();
					int[] as = new int[n];
					for (int i = 0; i < n; i++) {
						as[i] = scanner.nextInt();
					}
					for (int i = 1; i < 51; i++) {
						Arrays.fill(ln[i], 0);
						int winMax = i / s;
						for (int j = 0; j <= winMax; j++) {
							int rem = i - j * s;

							ln[i][j] = rem % t == 0 ? rem / t : rem / t + 1;
						}
					}

					for (int i = 0; i < n; i++) {
						Arrays.fill(dp[i], Integer.MAX_VALUE-100);
						int a = as[i];

						for (int wc = 0; wc < 51; wc++) {
							if (i == 0) {
								if (wc+ln[a][wc] <= m)
									dp[i][wc+ln[a][wc]] = Math.min(dp[i][wc+ln[a][wc]], wc);
								continue;
							}
							for (int j = 1; j <= m-wc-ln[a][wc]; j++) {
								dp[i][j+wc+ln[a][wc]] = Math.min(dp[i-1][j] + wc, dp[i][j+wc+ln[a][wc]]);
							}
						}
					}

					int minW = Integer.MAX_VALUE-100;
					for (int i = 0; i < m + 1; i++) {
						minW = Math.min(minW, dp[n-1][i]);
					}
					if (minW == Integer.MAX_VALUE-100)
						System.out.println("No");
					else
						System.out.println(minW);
				}
			}
		}
	}

	public static void main(String[] args) {
		new Main().deal();
	}
}
