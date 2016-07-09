package google.codejam.no5254486;

import google.codejam.CodejamUtils;

import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class MainA {
	
	public static void main(String[] args) throws IOException {
		Scanner scanner = CodejamUtils.getScanner("A-large", MainA.class);
		Writer writer = CodejamUtils.getWriter("A-large", MainA.class);

		int t = scanner.nextInt();
		for(int tt = 0; tt < t; tt++){
			String word = scanner.next();
			writer.write(String.format("Case #%d: %d\n", tt+1, calc(word)));
		}
		
		scanner.close();
		writer.close();

	}

	private static long calc(String word) {
		if (word == null || word.length() <= 1) return 1;
		long cnt = 1;
		int len = word.length();
		for (int i = 0; i < len; i++) {
			char cur = word.charAt(i);
			char prev = (i == 0) ? cur : word.charAt(i-1),
					next = (i == len-1) ? cur : word.charAt(i+1);

			int c = 1;
			if (cur != prev) c++;
			if (next != cur && next != prev) c++;
			cnt = cnt * c % 1000000007;
		}
		return cnt;
	}
}
