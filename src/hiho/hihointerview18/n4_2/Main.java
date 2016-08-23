package hiho.hihointerview18.n4_2;

import java.util.Scanner;

/**
 *
 * 多重背包问题，思路：
 * 		http://love-oriented.com/pack/P03.html
 * @author zkf
 *
 */

public class Main {
	private int n, m;
	private int[][] wp = new int[10][10];
	public void deal() {
		try(Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNextInt()) {
				n = scanner.nextInt();
				m = scanner.nextInt();
				for (int i = 0; i < n; i++) {
					int w = scanner.nextInt()-1;
					int p = scanner.nextInt()-1;
					wp[w][p]++;
				}

				solve();
			}
		}
	}

	private void _01pack(int cost, int val, int[] dp) {
		for (int i = dp.length-1; i >= cost; i--) {
			dp[i] = Math.max(dp[i], dp[i - cost] + val);
		}
	}

	private void multiPack(int cost, int val, int cnt, int[] dp) {
		if (cnt == 0) return;

		int curCnt = 1;
		while (curCnt <= cnt) {
			int cc = cost * curCnt;
			int vv = val * curCnt;
			_01pack(cc, vv, dp);

			cnt -= curCnt;
			curCnt *= 2;
		}
		_01pack(cost * cnt, val * cnt, dp);
	}

	private void solve() {
		int[] dp = new int[m+1];
		for (int need = 1; need < 11; need++) {
			for (int value = 1; value < 11; value++) {
				int count = wp[need-1][value-1];
				if (count == 0) continue;
				multiPack(need, value, count, dp);
			}
		}
		int max = 0;
		for (int i = 0; i <= m; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		new Main().deal();
	}
}
