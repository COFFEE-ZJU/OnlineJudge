package hiho.hihointerview18.n4;

import java.util.Scanner;

/**
 *
 * @author zkf
 *
 */

public class Main {
	private int n, m;
	private int[] w, p;
	public void deal() {
		try(Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNextInt()) {
				n = scanner.nextInt();
				m = scanner.nextInt();
				w = new int[n];
				p = new int[n];
				for (int i = 0; i < n; i++) {
					w[i] = scanner.nextInt();
					p[i] = scanner.nextInt();
				}

				solve();
			}
		}
	}

	private void solve() {
		int[] dp = new int[m+1];
		int[] dpPrev = new int[m+1];
		for (int i = 0; i < n; i++) {
			System.arraycopy(dpPrev, 0, dp, 0, w[i]);
			for (int j = w[i]; j <= m; j++) {
				dp[j] = Math.max(dpPrev[j], dpPrev[j-w[i]] + p[i]);
			}
			int[] tmp = dp;
			dp = dpPrev;
			dpPrev = tmp;
		}
		System.out.println(dpPrev[m]);
	}

	public static void main(String[] args) {
		new Main().deal();
	}
}
