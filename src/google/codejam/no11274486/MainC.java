package google.codejam.no11274486;

import google.codejam.CodejamUtils;

import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class MainC {
    private static double err = 0.0000000001;
    static int m;
    static double cost;
    static double[] income;
	
	public static void main(String[] args) throws IOException {
		Scanner scanner = CodejamUtils.getScanner("C-large", MainC.class);
		Writer writer = CodejamUtils.getWriter("C-large", MainC.class);

		int t = scanner.nextInt();
		for(int tt = 0; tt < t; tt++){
            m = scanner.nextInt();
            cost = 0 - scanner.nextDouble();
            income = new double[m];
            for (int i = 0; i < m; i++) {
                income[i] = scanner.nextDouble();
            }
            double left = 0, right = 2;
            while (right - left > err) {
                double mid = (right + left) / 2;
                if (calc(mid) < 0.0) right = mid;
                else left = mid;
            }
            writer.write(String.format("Case #%d: %.12f\n", tt+1, left-1));
		}
		
		scanner.close();
		writer.close();

	}

    private static double calc(double r_1) {
        double res = 0;
        double rr = 1;
        for (int i = m-1; i >= 0; i--) {
            res += income[i] * rr;
            rr *= r_1;
        }
        return res + cost * rr;
    }

}
