package google.codejam.no4284486;

import google.codejam.CodejamUtils;

import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class MainB {
	static class Cuboid{
		int n;
		int[] lens;
		public Cuboid(int n, int[] lens) {
			this.n = n;
			this.lens = lens;
		}

		public String query(int l, int r){
			double d = 1.0 / (r-l+1);
			double res = 1;
			for(int i = l; i <= r; i++)
				res *= Math.pow(lens[i], d);

			return String.format("%.9f", res);
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner scanner = CodejamUtils.getScanner("B-large-practice", MainB.class);
		Writer writer = CodejamUtils.getWriter("B-large-practice", MainB.class);
		
		int t = scanner.nextInt();
		for(int tt = 0; tt < t; tt++){
			writer.write("Case #"+(tt+1)+":\n");
			System.out.println("case "+tt);
			
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] lens = new int[n];
			for(int i = 0; i < n; i++)
				lens[i] = scanner.nextInt();
			
			Cuboid cuboid = new Cuboid(n, lens);
			for(int i = 0; i < m; i++){
				int l = scanner.nextInt(), r = scanner.nextInt();
				writer.write(cuboid.query(l, r) + "\n");
			}
		}
		
		
		scanner.close();
		writer.close();
	}
}

