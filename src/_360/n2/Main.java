package _360.n2;

import java.util.Scanner;

public class Main {
	private void deal() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String num = scanner.next();
			if ("0".equals(num)) {
				System.out.println(0);
				continue;
			}

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < num.length(); i++) {
				char c = num.charAt(i);
				if (c == '0') sb.append('0');
				else if (c == '1') sb.append('1');
				else {
					for (; i < num.length(); i++)
						sb.append('1');
				}
			}

			System.out.println(Integer.parseInt(sb.toString(), 2));
		}
	}

	public static void main(String[] args) {
		new Main().deal();
	}
}
