package hiho.no1239;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	private static final long MOD = 1000000007l;
    private static long[] dp;
	private static Map<Integer, Integer> posMap = new HashMap<Integer, Integer>();
	static {
		int fib1 = 1, fib2 = 2, pos = 2;
		while (fib2 <= 100000) {
			posMap.put(fib2, pos);
			int tmp = fib1 + fib2;
			fib1 = fib2;
			fib2 = tmp;
			pos++;
		}

		dp = new long[pos+1];
	}

	public static void solve(int[] a) {
		Arrays.fill(dp, 0);
		for (int i = 0; i < a.length; i++) {
			int num = a[i];
			if (a[i] == 1) {
				dp[1] = (dp[1] + dp[0]) % MOD;
				dp[0] = (dp[0] + 1) % MOD;
				continue;
			}

			Integer pos = posMap.get(num);
			if (pos == null) continue;

			dp[pos] = (dp[pos] + dp[pos-1]) % MOD;
		}
		long cnt = 0;
		for (int i = 0; i < dp.length; i++) {
			cnt = (cnt + dp[i]) % MOD;
		}
		System.out.println(cnt);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {
			int n = scanner.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = scanner.nextInt();
			}
			solve(a);
		}
	}
}
