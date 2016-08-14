package hiho.hihointerview17.n1;

import java.util.Scanner;

/**
 *
 * @author zkf
 *
 */

public class Main {
	private int n,m,k;
	private int[] attack;

	public void deal() {
		try(Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNextInt()) {
				n = scanner.nextInt();
				m = scanner.nextInt();
				k = scanner.nextInt();
				attack = new int[n];
				for (int i = 0; i < n; i++) {
					attack[i] = scanner.nextInt();
				}

				int tLeft = 1, tRight = m;
				if (canBreak(tRight)) {
					System.out.println(-1);
				} else if (!canBreak(tLeft)) {
					System.out.println(tLeft);
				} else {
					while (tLeft < tRight) {
						int mid = (tLeft + tRight) >>> 1;
						if (canBreak(mid)) tLeft = mid+1;
						else tRight = mid;
					}
					System.out.println(tLeft);
				}
			}
		}
	}

	private boolean canBreak(int t) {
		int rem = k, cur = m;
		for (int att : attack) {
			cur += t;
			if (cur > m) cur = m;
			cur -= att;
			if (cur <= 0) {
				rem--;
				cur = m;
				if (rem == 0) return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		new Main().deal();
	}
}
