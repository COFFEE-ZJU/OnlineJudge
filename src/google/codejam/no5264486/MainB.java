package google.codejam.no5264486;

import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

import google.codejam.CodejamUtils;

public class MainB {
	public static void main(String[] args) throws IOException {
        String fileName = "B-large-practice";
        Scanner scanner = CodejamUtils.getScanner(fileName, MainB.class);
		Writer writer = CodejamUtils.getWriter(fileName, MainB.class);

		int t = Integer.parseInt(scanner.nextLine());
		for(int tt = 0; tt < t; tt++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int r = Math.min(a, b), c = Math.max(a, b);
            if (c <= 2) {
                writer.write(String.format("Case #%d: %d\n", tt+1, a * b));
                continue;
            }
            int cnt = a * b;
            for (int i = 0; i < r; i++) {
                int len = c + (i % 3) - 3;
                int empty = len / 3 + 1;
                cnt -= empty;
            }
            writer.write(String.format("Case #%d: %d\n", tt+1, cnt));
        }
		
		scanner.close();
		writer.close();

	}
}
