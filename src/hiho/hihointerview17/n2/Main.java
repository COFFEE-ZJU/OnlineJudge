package hiho.hihointerview17.n2;

import java.util.Scanner;

/**
 *
 * @author zkf
 *
 */

public class Main {
	private int k,n;
	private int[] a;
	private double[] b;

	public void deal() {
		try(Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNextInt()) {
				n = scanner.nextInt();
				k = scanner.nextInt();
				a = new int[k];
				b = new double[k];
				for (int i = 0; i < k; i++) {
					a[i] = scanner.nextInt();
				}
				for (int i = 0; i < k; i++) {
					b[i] = 1.0 / scanner.nextInt();
				}

				System.out.println(maxScore());
			}
		}
	}

	private double maxScore() {
		double[] dpPrev = new double[n+1];
		double[] dp = new double[n+1];
		for (int i = 0; i <= n; i++) {
			dpPrev[i] = 1.0;
		}
		for (int i = 0; i < k; i++) {
			for (int j = 0; j <= n; j++) {
				double max = Double.MIN_VALUE;
				for (int l = 0; l <= j; l++) {
					max = Math.max(max, dpPrev[l] * Math.pow(a[i] + j - l, b[i]));
				}
				dp[j] = max;
			}
			System.arraycopy(dp, 0, dpPrev, 0, n+1);
		}
		return dpPrev[n];
	}

	public static void main(String[] args) {
		new Main().deal();
	}
}
