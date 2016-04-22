package hiho.netease.n3;

import java.util.Scanner;

public class Main {
	char[] curC;
	long curL, endL;
	int _2s, _3s, _5s;
	long cnt;

	private long findCnt(long n, long m) {
		long rem = n % 7;
		if (rem == 0) n -= 7;
		else n -= rem;

		char[] start = new StringBuilder(String.format("%019d", n)).reverse().toString().toCharArray();

		curC = start;
		curL = n;
		_2s = _3s = _5s = 0;
		cnt = 0;
		endL = m;

		for (int i = 0; i < 19; i++) {
			update235(curC[i], 1);
		}

		while (curL <= endL) {
			addAndUpdate();
		}

		return cnt;
	}

	private void checkAndRemove18(int st, boolean checkAll) {
		int idx = -1;
		for (int i = st; i > 0 ; i--) {
			if (curC[i] == '1' && curC[i-1] == '8') {
				idx = i-1;
				break;
			}

			if (!checkAll) break;
		}

		if (idx == -1) return;

		if (idx != 0) {
			for (int i = idx - 1; i >= 0; i--) {
				update235(curC[i], -1);
				curC[i] = '9';
			}

			curL /= 10;
			curL *= 10;
			curL += Math.pow(10, idx);
			curL--;

			long rem = curL % 7;
			curL -= rem;
			curC[0] -= rem;
			update235(curC[0], 1);
		}

		add7();
	}

	private int add7() {
		int i;
		for (i = 0;; i++) {
			update235(curC[i], -1);
			curC[i] += (i==0 ? 7 : 1);
			if (curC[i] > '9') {
				curC[i] -= 10;
				update235(curC[i], 1);
			}
			else {
				update235(curC[i], 1);
				break;
			}
		}
		curL += 7;

		return i;
	}

	private void addAndUpdate() {
		int i = add7();

		checkAndRemove18(i+1, false);
		if ((_2s != 0 || _3s != 0 || _5s != 0) && curL <= endL)
			cnt++;
	}

	private void update235(char c, int diff) {
		if (c == '2') _2s += diff;
		else if (c == '3') _3s += diff;
		else if (c == '5') _5s += diff;
	}

	public void deal() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {
			int r = scanner.nextInt();
			for (int rr = 0; rr < r; rr++) {
				long n = scanner.nextLong(), m = scanner.nextLong();
				System.out.println(findCnt(n,m));
				System.out.println(findCntNaive(n,m));
			}
		}
	}

	private boolean isLegal(long n) {
		if (n % 7 != 0) return false;
		String num = String.valueOf(n);
		if (num.contains("18")) return false;

		return num.contains("2") || num.contains("3") || num.contains("5");
	}
	private int findCntNaive(long n, long m) {
		int cnt = 0;
		while (n <= m) {
			if (isLegal(n))
				cnt++;
			n++;
		}

		return cnt;
	}

	public static void main(String[] args) {
		new Main().deal();
	}
}
