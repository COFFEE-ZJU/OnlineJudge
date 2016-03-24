package google.codejam.no6234486;

import google.codejam.CodejamUtils;

import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class MainB {
	
	public static void main(String[] args) throws IOException {
		Scanner scanner = CodejamUtils.getScanner("B-small-practice", MainB.class);
		Writer writer = CodejamUtils.getWriter("B-small-practice", MainB.class);

		int t = scanner.nextInt();
		for(int tt=0; tt<t; tt++){
			writer.write(format(tt+1, calcDegree(scanner.nextInt(), scanner.nextInt())) + "\n");
		}

		writer.close();
		scanner.close();
	}
	
	private static double calcDegree(double v, double d){
		double a = 9.8 * 9.8 * d * d / Math.pow(v, 4);
		if (a > 1) a = 1;
		System.out.println(a);
		return Math.toDegrees(Math.asin(Math.sqrt((1.0 - Math.sqrt(1.0 - a)) / 2.0)));
	}
	
	private static String format(int caseNo, double d){
		return String.format("Case #%d: %.7f", caseNo, d);
	}
}
