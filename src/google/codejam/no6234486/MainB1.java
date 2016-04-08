package google.codejam.no6234486;

import google.codejam.CodejamUtils;

import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class MainB1 {
	public static void tmp(String[] args) {
		System.out.println(format(1, calcDegree(98, 980)));
		System.out.println(format(2, calcDegree(98, 490)));
		System.out.println(format(3, calcDegree(299, 1234)));
	}
	
	public static void main(String[] args) throws IOException {
		Scanner scanner = CodejamUtils.getScanner("B-small-practice", MainB1.class);
		Writer writer = CodejamUtils.getWriter("B-small-practice", MainB1.class);
		
		int t = scanner.nextInt();
		for(int tt=0; tt<t; tt++){
			writer.write(format(tt+1, calcDegree(scanner.nextInt(), scanner.nextInt())) + "\n");
		}
		
		writer.close();
		scanner.close();
	}
	
	private static double calcDegree(double v, double d){
		double V = v*v;
		double tmp = V*V - d*d*9.8*9.8;
		tmp = Math.round(tmp * 1000000) / 1000000;
		double Vup = (V-Math.sqrt(tmp)) / 2;
		System.out.println(String.format("Vup: %.7f, v: %.1f, d: %.1f", Vup, v, d));
		if(Vup <= 0.0001)
			Vup = (V+Math.sqrt(tmp)) / 2;
		if(Double.isNaN(Vup)){
			System.err.println("NaN found");
			System.err.println(V*V - d*d*9.8*9.8);
		}
		return Math.toDegrees(Math.asin(Math.sqrt(Vup/V)));
	}
	
	private static String format(int caseNo, double d){
		return String.format("Case #%d: %.7f", caseNo, d);
	}
}
