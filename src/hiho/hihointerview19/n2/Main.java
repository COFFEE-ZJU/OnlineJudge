package hiho.hihointerview19.n2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author zkf
 *
 */

public class Main {
	private int n;

	public void deal() {
		try(Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNextInt()) {
				n = scanner.nextInt();
				Set<String> words = new HashSet<>();
				int pairs = 0;
				for (int i = 0; i < n; i++) {
					String w = scanner.next();
					if (words.contains(w)) {
						pairs++;
						continue;
					}
					words.add(new StringBuilder(w).reverse().toString());
				}
				System.out.println(pairs);
			}
		}
	}


	public static void main(String[] args) {
		new Main().deal();
	}
}
