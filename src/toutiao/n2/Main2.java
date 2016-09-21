package toutiao.n2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main2 {

	public int solve(int m, int[] nums) {
		int cnt = 0, n = nums.length;
		for (int i = 0; i < n-1; i++) {
			for (int j = i+1; j < n; j++) {
				if ((nums[i] ^ nums[j]) > m) cnt++;
			}
		}
		return cnt;
	}

	private void deal() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = scanner.nextInt();
			}

			System.out.println(solve(m, nums));
		}
	}

	public static void main(String[] args) {
		Main2 main2 = new Main2();
		Main main = new Main();
		Random rand = new Random(System.currentTimeMillis());
		while (true) {
			int n = rand.nextInt(100);
			int m = rand.nextInt(100000);
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = rand.nextInt(100000);
			}
			int ans2 = main2.solve(m, nums);
			int ans = main.solve(m, nums);
			if (ans != ans2) {
				System.out.println("m : " + m);
				System.out.println("nums: " + Arrays.toString(nums));
				System.out.println("ans: " + ans + ", " + ans2);
				break;
			}
		}
	}
}
