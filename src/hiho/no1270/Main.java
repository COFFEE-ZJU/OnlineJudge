package hiho.no1270;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static long[] dp = new long[10002];

	public static void solve(int m, int n, int k, int t, int[] a, int[] b) {
		boolean solvable = false;
		for (int i = 0; i < m; i++) {
			int tmp = b[i];
			for (int j = 0; j < n - 1; j++) {
				tmp /= t;
			}
			if (tmp != 0) {
				solvable = true;
				break;
			}
		}

		if (!solvable) {
			System.out.println("No Answer");
			return;
		}

		long cost = 0;
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp, Integer.MAX_VALUE);
			dp[0] = 0;
			for (int j = 0; j < k; j++) {
				for (int l = 0; l < m; l++) {
					if (b[l] == 0) continue;
					int nextK = Math.min(k, j + b[l]);
					dp[nextK] = Math.min(dp[nextK], dp[j] + a[l]);
				}
			}
			cost += dp[k];
			for (int j = 0; j < m; j++) {
				b[j] /= t;
			}
		}

		System.out.println(cost);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {
			int r = scanner.nextInt();
			for (int rr = 0; rr < r; rr++) {
				int n = scanner.nextInt(), m = scanner.nextInt(), k = scanner.nextInt(), t = scanner.nextInt();
				int[] a = new int[m], b = new int[m];
				for (int i = 0; i < m; i++) {
					a[i] = scanner.nextInt();
				}
				for (int i = 0; i < m; i++) {
					b[i] = scanner.nextInt();
				}

				solve(m,n,k,t,a,b);
			}
		}
	}
}
