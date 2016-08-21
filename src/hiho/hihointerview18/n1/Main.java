package hiho.hihointerview18.n1;

import java.util.Scanner;

/**
 *
 * @author zkf
 *
 */

public class Main {
	public void deal() {
		try(Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNext()) {
				String s = scanner.next().replace('J', 'I');
				boolean[] occr = new boolean[26];
				occr['J'-'A'] = true;
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < s.length(); i++) {
					int pos = s.charAt(i) - 'A';
					if (occr[pos]) continue;

					occr[pos] = true;
					sb.append(s.charAt(i));
				}
				for (int i = 0; i < 26; i++) {
					if (!occr[i]) sb.append((char)('A'+i));
				}
				printMatrix(sb);
			}
		}
	}

	private void printMatrix(StringBuilder sb) {
		System.out.println(sb.substring(0, 5));
		System.out.println(sb.substring(5, 10));
		System.out.println(sb.substring(10, 15));
		System.out.println(sb.substring(15, 20));
		System.out.println(sb.substring(20, 25));
	}

	public static void main(String[] args) {
		new Main().deal();
	}
}
