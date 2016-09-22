package youdao.n1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	private void deal() {
		Scanner scanner = new Scanner(System.in);
		List<Integer> res = new ArrayList<>();
		while (scanner.hasNextInt()) {
			int n = scanner.nextInt();
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int[] h = new int[n];
			for (int i = 0; i < n; i++) {
				h[i] = scanner.nextInt();
			}

			res.clear();
			for (int i = 1; i < n - 1; i++) {
				while (h[i-1] >= 0) {
					res.add(i+1);
					h[i-1] -= b;
					h[i] -= a;
					h[i+1] -= b;
				}
			}
			while (h[n-2] >= 0 || h[n-1] >= 0) {
				res.add(n-1);
				h[n-2] -= a;
				h[n-1] -= b;
			}
			System.out.println(res.size());
			for (int i = 0; i < res.size(); i++) {
				if (i != 0) {
					System.out.print(" ");
				}
				System.out.print(res.get(i));
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		new Main().deal();
	}
}
