package toutiao.n2;

import java.util.Scanner;

public class Main {
	private static class Tree {
		Tree _0, _1;
		int cnt;

		void add(int num, int pos) {
			cnt++;

			if (pos == 32) return;
			if (!getBit(num, pos)) {
				if (_0 == null) _0 = new Tree();
				_0.add(num, pos+1);
			} else {
				if (_1 == null) _1 = new Tree();
				_1.add(num, pos+1);
			}
		}

		public int getLegitCnt(int target, int num, int pos) {
			if (pos == 32) return 0;
			boolean bitT = getBit(target, pos);
			boolean bitN = getBit(num, pos);
			if (bitT) {
				if (bitN && _0 != null) return _0.getLegitCnt(target, num, pos + 1);
				if (!bitN && _1 != null) return _1.getLegitCnt(target, num, pos + 1);
				return 0;
			} else {
				int cnt = 0;
				if (bitN && _0 != null) cnt += _0.cnt;
				if (!bitN && _1 !=null) cnt += _1.cnt;

				if (bitN && _1 != null) return cnt + _1.getLegitCnt(target, num, pos + 1);
				if (!bitN && _0 != null) return cnt + _0.getLegitCnt(target, num, pos + 1);
				return cnt;
			}
		}
	}

	private static boolean getBit(int num, int pos) {
		if ((num & (1 << (31-pos))) == 0) return false;
		else return true;
	}

	public int solve(int m, int[] nums) {
		int n = nums.length;
		Tree root = new Tree();
		for (int i = 0; i < n; i++) {
			root.add(nums[i], 0);
		}

		int cnt = 0;
		for (int num : nums) {
			cnt += root.getLegitCnt(m, num, 0);
		}
		return cnt / 2;
	}

	private void deal() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			Tree root = new Tree();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = scanner.nextInt();
				root.add(nums[i], 0);
			}

			int cnt = 0;
			for (int num : nums) {
				cnt += root.getLegitCnt(m, num, 0);
			}
			System.out.println(cnt / 2);
		}
	}

	public static void main(String[] args) {
		new Main().deal();
	}
}
