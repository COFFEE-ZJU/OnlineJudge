package hiho.ms.n2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public void deal() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {
			int len = scanner.nextInt();
			char[] str = scanner.next().toCharArray();

			Set<Integer> pairs = new HashSet<>();
			int cnt = scanner.nextInt();
			for (int i = 0; i < cnt; i++) {
				addIllegalPair(pairs, scanner.next());
			}

			int[] dp = new int[27], dpPrev = new int[27];
			Arrays.fill(dpPrev, Integer.MAX_VALUE);
			dpPrev[26] = 1;
			dpPrev[str[0]-'a'] = 0;
			for (int i = 1; i < len; i++) {
				int cur = str[i] - 'a';
				for (int j = 0; j < 27; j++) {
					dp[j] = dpPrev[j] != Integer.MAX_VALUE ? dpPrev[j] + 1 : Integer.MAX_VALUE;
					if (j != cur) continue;

					for (int k = 0; k < 27; k++) {
						if (isLegal(pairs, k, cur)) {
							dp[j] = Math.min(dp[j], dpPrev[k]);
						}
					}
				}

				int[] tmp = dpPrev;
				dpPrev = dp;
				dp = tmp;
			}

			int min = len;
			for (int i = 0; i < 27; i++) {
				min = Math.min(min, dpPrev[i]);
			}
			System.out.println(min);
		}
	}

	private boolean isLegal(Set<Integer> pairs, int i, int j) {
		if (i == 26 || j == 26) return true;
		return !(pairs.contains(i * 26 + j) || pairs.contains(j * 26 + i));
	}

	private void addIllegalPair(Set<Integer> pairs, String pair) {
		int i = pair.charAt(0) - 'a', j = pair.charAt(1) - 'a';
		pairs.add(i * 26 + j);
		pairs.add(j * 26 + i);
	}

	public static void main(String[] args) {
		new Main().deal();
	}
}
