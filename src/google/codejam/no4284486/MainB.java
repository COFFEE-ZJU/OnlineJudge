package google.codejam.no4284486;

import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

import google.codejam.CodejamUtils;

public class MainB {
	
	public static void test(){
//		System.out.println(Cuboid.rootN_Decimal("6", 2, 9));
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
		
//		test();
	}

}

class Cuboid{
	int n;
	int[] lens;
	public Cuboid(int n, int[] lens) {
		this.n = n;
		this.lens = lens;
	}
	
	public String query(int l, int r){
		int d = r-l+1;
		BigInteger bi = BigInteger.valueOf(1);
		for(int i = l; i <= r; i++)
			bi = bi.multiply(BigInteger.valueOf(lens[i]));
		
		return rootN_Decimal(bi, d, 6);
	}
	
	public static String rootN_Decimal(BigInteger num,int n,int precision){
	
		BigDecimal x=new BigDecimal(num.divide(BigInteger.valueOf(n)));
		BigDecimal x0=BigDecimal.ZERO;
		
		BigDecimal e=new BigDecimal("0.1");
		for(int i=1;i<precision;++i)
			e=e.divide(BigDecimal.TEN,i+1,BigDecimal.ROUND_HALF_EVEN);
		
		BigDecimal K=new BigDecimal(num);
		BigDecimal m=new BigDecimal(n);
		
		long i=0;
		while(x.subtract(x0).abs().compareTo(e)>0)
		{
			x0=x;
			x=x.add(K.subtract(x.pow(n)).divide(m.multiply(x.pow(n-1)),precision,BigDecimal.ROUND_HALF_EVEN));
			++i;
		}	
		return x.toString();//+" "+i;
	}
}