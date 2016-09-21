package _360.n1;

import java.util.Scanner;

public class Main {
	private void deal() {
		Scanner scanner = new Scanner(System.in);
		char[][] lines = new char[3][];
		while (scanner.hasNext()) {
			for (int i = 0; i < 3; i++) {
				lines[i] = scanner.next().toCharArray();
			}
			boolean legit = true;
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 3; j++) {
					if (lines[i][j] != lines[2-i][2-j]) {
						legit = false;
						break;
					}
				}
				if (!legit) break;
			}

			System.out.println(legit ? "YES" : "NO");
		}
	}

	public static void main(String[] args) {
		new Main().deal();
	}
}
