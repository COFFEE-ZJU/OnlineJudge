package hiho.hihointerview18.n2_2;

import java.util.Scanner;

/**
 *
 * @author zkf
 *
 */

public class Main {

	private int m, n, l, maxMin;
	private int[] as;

	public void deal() {
		try(Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNextInt()) {
				n = scanner.nextInt();
				m = scanner.nextInt();
				l = scanner.nextInt();
				as = new int[2*n];
				for (int i = 0; i < n; i++) {
					as[i+n] = as[i] = scanner.nextInt();
				}

				int maxMin = 0;
				for (int i = 0; i < n; i++) {
					if (as[i] < maxMin) continue;
						int mm = m;
					int j;
					for (j = i+1; j < i + n;) {
						for (;as[j] >= as[i] && j < i + n; j++);
						if (j >= i+n || mm <= 0) break;
						mm--;
						j += l;
					}
					for (;as[j] >= as[i] && j < i + n; j++);
					if (j >= i+n) {
						maxMin = Math.max(maxMin, as[i]);
					}
				}

				System.out.println(maxMin);
			}
		}
	}

	public static void main(String[] args) {
		new Main().deal();
	}
}
