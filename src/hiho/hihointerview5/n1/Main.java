package hiho.hihointerview5.n1;

import java.util.Scanner;

/**
 * 
 * Problem Description: http://hihocoder.com/contest/msinterntest/problem/1
 * @author zkf
 *
 */

public class Main {
	public void deal() {
		StringBuilder sb = new StringBuilder();
		try(Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNextInt()) {
				int n = scanner.nextInt();
				int[] order = new int[n];
				for (int i = 0; i < n; i++) {
					order[i] = scanner.nextInt();
				}
				sb.setLength(0);
				int endPos = n-1;
				for (int i = n-1; i > 0; i--) {
					endPos = i-1;
					if (order[i-1] > order[i])
						break;
				}
				for (int i = 0; i <= endPos; i++) {
					System.out.print(order[i] + (i==endPos ? "\n" : " "));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new Main().deal();
	}
}
