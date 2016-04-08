package hiho.msintern.n1;

import java.util.Scanner;

public class Main {
	public void deal() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {
			int r = scanner.nextInt();
			for (int rr = 0; rr < r; rr++) {
				int n = scanner.nextInt(), p = scanner.nextInt(), w = scanner.nextInt(), h = scanner.nextInt();
				int[] a = new int[n];
				for (int i = 0; i < n; i++) {
					a[i] = scanner.nextInt();
				}
				int left = 1, right = Math.min(w,h);
				while (left <= right) {
					int mid = (left + right) >>> 1;
					int col = w/mid, row = 0;
					for (int i = 0; i < n; i++) {
						row += Math.ceil(1.0 * a[i] / col);
					}

					int pages = (int) Math.ceil(1.0 * row / (h/mid));
					if (pages <= p) left = mid+1;
					else right = mid-1;
				}
				System.out.println(right);
			}
		}
	}

	public static void main(String[] args) {
		new Main().deal();
	}
}
