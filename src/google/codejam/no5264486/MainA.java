package google.codejam.no5264486;

import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

import google.codejam.CodejamUtils;

public class MainA {
	public static void main(String[] args) throws IOException {
	    String fileName = "A-large-practice";
        Scanner scanner = CodejamUtils.getScanner(fileName, MainA.class);
		Writer writer = CodejamUtils.getWriter(fileName, MainA.class);

		int t = Integer.parseInt(scanner.nextLine());
		for(int tt = 0; tt < t; tt++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            double[] dp = new double[a+1], dpPrev = new double[a+1];
            dpPrev[1] = 1.0 * a / (a+b);
            for (int i = 1; i < a + b; i++) {
                int rem = a + b - i;
                for (int j = 1; j <= a; j++) {
                    int remA = a - (i + j - 1) / 2;
                    dp[j] = dpPrev[j - 1] * remA / rem;
                    if (j == a) continue;
                    int remB = b - (i - j - 1) / 2;
                    dp[j] += dpPrev[j + 1] * remB / rem;
                }
                double[] tmp = dp;
                dp = dpPrev;
                dpPrev = tmp;
            }

            double sum = 0;
            for (double n : dpPrev) sum += n;
            writer.write(String.format("Case #%d: %.8f\n", tt+1, sum));
        }
		
		scanner.close();
		writer.close();

	}
}
