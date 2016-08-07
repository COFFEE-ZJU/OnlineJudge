package hiho.hihointerview16.n1;

import java.util.Scanner;

/**
 *
 * @author zkf
 *
 */

public class Main {
	public void deal() {
		try(Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNextInt()) {
				int n = scanner.nextInt();
				int x = scanner.nextInt();
				int[] prices = new int[n];
				for (int i = 0; i < n; i++) {
					prices[i] = scanner.nextInt();
				}

				int min = Integer.MAX_VALUE;
				boolean[] dp = new boolean[x];
				dp[0] = true;
				for (int p : prices) {
					for (int i = x-1; i >= 0; i--) {
						if (dp[i] == true) {
							if (i+p >= x) {
								min = Math.min(i+p, min);
//								if (min == x) break;
							} else {
								dp[i+p] = true;
							}
						}
					}
				}

				System.out.println(min == Integer.MAX_VALUE ? -1 : min);
			}
		}
	}
	
	public static void main(String[] args) {
		new Main().deal();
	}
}
