package hiho.hihointerview19.n1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author zkf
 *
 */

public class Main {
	private int m,n,minHeight;
	private int[][] whs;
	private Map<Integer, Integer> remHeightMap = new HashMap<>();

	public void deal() {
		try(Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNext()) {
				m = scanner.nextInt();
				n = scanner.nextInt();
				whs = new int[n][2];
				for (int i = 0; i < n; i++) {
					whs[i][0] = scanner.nextInt();
					whs[i][1] = scanner.nextInt();
				}

				solve();
			}
		}
	}

	private int[] solve1Line(int stN) {
		int curHgt = 0, remWid = m;
		int curN = stN;
		while (remWid > 0 && curN < n) {
			int w = whs[curN][0], h = whs[curN][1];
			if (w <= remWid) {
				remWid -= w;
			} else {
				h *= remWid;
				boolean carry = h % w != 0;
				h /= w;
				if (carry) h++;
				remWid = 0;
			}
			curHgt = Math.max(curHgt, h);
			curN++;
		}
		return new int[]{curHgt, curN};
	}

	private int solveRem(int stN) {
		if (stN >= n) return 0;
		Integer cache = remHeightMap.get(stN);
		if (cache != null) return cache;

		int[] hn = solve1Line(stN);
		int height = hn[0] + solveRem(hn[1]);
		remHeightMap.put(stN, height);
		return height;
	}

	private void solve() {
		remHeightMap.clear();
		minHeight = Integer.MAX_VALUE;

		int stN = 0, curHeight, aboveHeight = 0;
		while (stN < n) {
			int[] _1line = solve1Line(stN);
			int nextN = _1line[1];
			for (int i = stN; i < nextN; i++) {
				int w = whs[i][0], h = whs[i][1];
				whs[i][0] = whs[i][1] = 0;
				int[] curSol = solve1Line(stN);
				minHeight = Math.min(minHeight, aboveHeight + curSol[0] + solveRem(curSol[1]));
				whs[i][0] = w;
				whs[i][1] = h;
			}

			aboveHeight += _1line[0];
			stN = nextN;
		}

		System.out.println(minHeight);
	}

	public static void main(String[] args) {
		new Main().deal();
	}
}
