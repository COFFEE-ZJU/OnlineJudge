package hiho.hihointerview17.n3;

import java.util.*;

/**
 *
 * @author zkf
 *
 */

public class Main {
	private static class IntArr {
		final int[] nums;

		private IntArr(int[] nums) {
			this.nums = nums;
		}

		@Override
		public boolean equals(Object o) {
			IntArr intArr = (IntArr) o;

			return Arrays.equals(nums, intArr.nums);

		}

		@Override
		public int hashCode() {
			return Arrays.hashCode(nums);
		}
	}

	private int n;
	private int[] nums;

	public void deal() {
		try(Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNextInt()) {
				n = scanner.nextInt();
				nums = new int[n];
				for (int i = 0; i < n; i++) {
					nums[i] = scanner.nextInt();
				}
				System.out.println(minSwap());
			}
		}
	}

	private int minSwap() {
		if (n <= 2 || isLegit(nums)) return 0;
		int curSwapNum = 1;
		Set<IntArr> seen = new HashSet<>();
		seen.add(new IntArr(nums));
		List<IntArr> toDeal = new ArrayList<>();
		List<IntArr> dealing = new ArrayList<>();
		dealing.add(new IntArr(nums));
		while (!dealing.isEmpty()) {
			toDeal.clear();
			for (IntArr deal: dealing) {
				for (int i = 0; i < n - 1; i++) {
					for (int j = i+1; j < n; j++) {
						IntArr nn = new IntArr(Arrays.copyOf(deal.nums, n));
						int t = nn.nums[i];
						nn.nums[i] = nn.nums[j];
						nn.nums[j] = t;
						if (!seen.add(nn))
							continue;

						if (isLegit(nn.nums))
							return curSwapNum;

						toDeal.add(nn);
					}
				}
			}
			List<IntArr> tmp = toDeal;
			toDeal = dealing;
			dealing = tmp;
			curSwapNum++;
		}
		return -1;
	}

	private boolean isLegit(int[] nums) {
		for (int i = 1; i < n - 1; i++) {
			if ((nums[i] > nums[i-1] && nums[i] > nums[i+1]) ||
					(nums[i] < nums[i-1] && nums[i] < nums[i+1]))
				continue;
			else
				return false;
		}

		return true;
	}


	public static void main(String[] args) {
		new Main().deal();
	}
}
