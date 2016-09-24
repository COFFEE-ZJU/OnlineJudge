package xiaomi.n2;

import java.util.Scanner;

public class Main {
	private void deal() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			String[] words = scanner.nextLine().split(" ");
			for (int i = words.length-1; i >= 0 ; i--) {
				System.out.print(words[i]);
				if (i == 0)
					System.out.println();
				else
					System.out.print(" ");

			}
		}
	}

	public static void main(String[] args) {
		new Main().deal();
	}
}
