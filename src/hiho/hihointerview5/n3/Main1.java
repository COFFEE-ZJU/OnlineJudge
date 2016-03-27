package hiho.hihointerview5.n3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * Problem Description: http://hihocoder.com/contest/msinterntest/problem/1
 * @author zkf
 *
 */

public class Main1 {
	public void deal() {
		StringBuilder sb = new StringBuilder();
		try(Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNextInt()) {
				int r = scanner.nextInt();
				for (int rr = 0; rr < r; rr++) {
					int n = scanner.nextInt(), m = scanner.nextInt(),
							s = scanner.nextInt(), t = scanner.nextInt();
					int dif = s - t;
					int[] as = new int[n];
					int[] winScore = new int[n], remScore = new int[n];
					int[] chance = new int[n];
					int winCnt = 0;
					for (int i = 0; i < n; i++) {
						as[i] = scanner.nextInt();
					}
					for (int i = 0; i < n; i++) {
						chance[i] = as[i] / s;
						if (as[i] % s != 0) chance[i]++;
						remScore[i] = chance[i] * s - as[i];
						chance[i] -= remScore[i] / dif;
						remScore[i] %= dif;

						m -= chance[i];
					}
					if (m < 0) {
						System.out.println("No");
						continue;
					}

					Arrays.sort(remScore);

				}
			}
		}
	}

	public static void main(String[] args) {
		new Main1().deal();
	}
}
