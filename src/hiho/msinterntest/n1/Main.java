package hiho.msinterntest.n1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * Problem Description: http://hihocoder.com/contest/msinterntest/problem/1
 * @author zkf
 *
 */

public class Main {
	public void deal() {
		int[] digits = new int[10];
		int[] apbs = new int[26];
		StringBuilder sb = new StringBuilder();
		try(Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNextLine()) {
				boolean illegal = false;
				String str = scanner.nextLine();
				for (int i = 0; i < str.length(); i++) {
					char c = str.charAt(i);
					if (c >= '0' && c <= '9')
						digits[c-'0']++;
					else if (c >= 'a' && c <= 'z')
						apbs[c-'a']++;
					else {
						illegal = true;
						System.out.println("<invalid input string>");
						break;
					}
				}

				if (!illegal) {
					sb.setLength(0);
					boolean empty = false;
					while (!empty) {
						empty = true;
						for (int i = 0; i < 10; i++) {
							if (digits[i] > 0) {
								empty = false;
								sb.append((char) ('0' + i));
								digits[i]--;
							}
						}
						for (int i = 0; i < 26; i++) {
							if (apbs[i] > 0) {
								empty = false;
								sb.append((char) ('a' + i));
								apbs[i]--;
							}
						}
					}
					System.out.println(sb.toString());
				}
				Arrays.fill(digits, 0);
				Arrays.fill(apbs, 0);
			}
		}
	}
	
	public static void main(String[] args) {
		new Main().deal();
	}
}
