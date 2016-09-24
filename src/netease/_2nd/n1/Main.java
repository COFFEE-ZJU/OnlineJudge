package netease._2nd.n1;

import java.util.Scanner;

public class Main {
	private void deal() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLong()) {
			long a = scanner.nextLong();
			long b = scanner.nextLong();
			long c = scanner.nextLong();
			int target = getSum(c);

			int minDis = Integer.MAX_VALUE;
			long res = -1;
			for (long i = a; i <= b; i++) {
				int sum = getSum(i);
				int dis = Math.abs(sum - target);
				if (dis < minDis) {
					minDis = dis;
					res = i;
				}
			}
			System.out.println(res);
		}
	}

	private int getSum(long n) {
		int sum = 0;
		while (n != 0) {
			sum += n % 10;
			n /= 10;
		}
		return sum;
	}

	public static void main(String[] args) {
		new Main().deal();
	}
}
