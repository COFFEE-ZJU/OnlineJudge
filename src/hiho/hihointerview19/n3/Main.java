package hiho.hihointerview19.n3;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author zkf
 *
 */

public class Main {
	private int target;
	private int[] digits;

	public void deal() {
		try(Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNext()) {
				String[] s = scanner.next().split("=");
				target = Integer.parseInt(s[1]);
				String[] qs = s[0].split("\\+");
				digits = new int[qs.length];
				for (int i = 0; i < qs.length; i++) {
					digits[i] = qs[i].length();
				}
				Arrays.sort(digits);

				solve();
			}
		}
	}

	private static StringBuilder sb = new StringBuilder();
	static {
		sb.append('1');
		for (int i = 0; i < 100; i++) {
			sb.append('0');
		}
	}

	private Map<Integer, BigInteger> minCache = new HashMap<>();
	private BigInteger rangeMin(int digit) {
		BigInteger bi = minCache.get(digit);
		if (bi == null) {
			bi = new BigInteger(sb.substring(0, digit));
			minCache.put(digit, bi);
		}
		return bi;
	}
	private Map<Integer, BigInteger> maxCache = new HashMap<>();
	private BigInteger rangeMax(int digit) {
		BigInteger bi = maxCache.get(digit);
		if (bi == null) {
			bi = new BigInteger(sb.substring(0, digit+1)).subtract(BigInteger.ONE);
			maxCache.put(digit, bi);
		}
		return bi;
	}

	private long solve(BigInteger target, int idx, BigInteger min, BigInteger max) {
		if (target.compareTo(min) < 0 || target.compareTo(max) > 0)
			return 0;
		if (idx == digits.length - 1)
			return 1;

		int digit = digits[idx];
		BigInteger rMin = rangeMin(digit), rMax = rangeMax(digit);
		BigInteger nextMin = min.subtract(rMin), nextMax = max.subtract(rMax);
		long sol = 0;
		for (BigInteger bi = rMin; bi.compareTo(rMax) <= 0; bi = bi.add(BigInteger.ONE)) {
			sol += solve(target.subtract(bi), idx+1, nextMin, nextMax);
			sol %= 1000000007L;
		}
		return sol;
	}

	private void solve() {
		BigInteger min = BigInteger.ZERO;
		BigInteger max = BigInteger.ZERO;
		for (int i = 0; i < digits.length; i++) {
			min = min.add(rangeMin(digits[i]));
			max = max.add(rangeMax(digits[i]));
		}
		System.out.println(solve(BigInteger.valueOf(target), 0, min, max));
	}

	public static void main(String[] args) {
		new Main().deal();
//		System.out.println(Arrays.toString("??+?=23".split("\\+")));
	}
}
