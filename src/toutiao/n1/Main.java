package toutiao.n1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private void deal() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {
			int n = scanner.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = scanner.nextInt();
			}
			Arrays.sort(nums);
			int curCnt = 0, prev = 0;
			int addCnt = 0;
			for (int i = 0; i < n; ) {
				int num = nums[i];
				if (curCnt != 0 && num - prev > 10) {
					addCnt++;
					prev += 10;
				} else {
					i++;
					prev = num;
				}
				curCnt = (curCnt + 1) % 3;
			}
			if (curCnt != 0) addCnt += (3-curCnt);
			System.out.println(addCnt);
		}
	}

	public static void main(String[] args) {
		new Main().deal();
	}
}
