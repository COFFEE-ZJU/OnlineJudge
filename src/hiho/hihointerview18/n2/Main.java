package hiho.hihointerview18.n2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author zkf
 *
 */

public class Main {
	private class Situation {
		private final int[] as;
		private final int remTime;

		private Situation(int[] as, int remTime) {
			this.as = as;
			this.remTime = remTime;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}

			Situation situation = (Situation) o;

			if (remTime != situation.remTime) {
				return false;
			}
			return Arrays.equals(as, situation.as);
		}

		@Override
		public int hashCode() {
			int result = Arrays.hashCode(as);
			result = 31 * result + remTime;
			return result;
		}
	}

	private int m, n, l, maxMin;
	private int[] as;

	public void deal() {
		try(Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNextInt()) {
				n = scanner.nextInt();
				m = scanner.nextInt();
				l = scanner.nextInt();
				as = new int[n];
				for (int i = 0; i < n; i++) {
					as[i] = scanner.nextInt();
				}

				maxMinMap.clear();
				maxMin = Integer.MIN_VALUE;
				solve(new Situation(as, m));
				System.out.println(maxMin);
			}
		}
	}

	private Set<Situation> maxMinMap = new HashSet<>();

	private void solve(Situation situation) {
		if (!maxMinMap.add(situation)) return;
		int minPos = findMinIdx(situation.as);
		if (situation.remTime == 0) {
			maxMin = Math.max(maxMin, situation.as[minPos]);
			return;
		}

		for (int i = minPos-l+1; i <= minPos; i++) {
			solve(fix(situation, i));
		}
	}

	private Situation fix(Situation situation, int start) {
		int[] nas = Arrays.copyOf(situation.as, n);
		for (int i = start; i < start + l; i++) {
			if (i < 0) i += n;
			else if (i >= n) i -= n;
			nas[i] = Integer.MAX_VALUE;
		}
		return new Situation(nas, situation.remTime-1);
	}

	private int findMinIdx(int[] as) {
		int idx = 0, min = Integer.MAX_VALUE;
		for (int i = 0; i < as.length; i++) {
			if (min > as[i]) {
				min = as[i];
				idx = i;
			}
		}
		return idx;
	}

	public static void main(String[] args) {
		new Main().deal();
	}
}
