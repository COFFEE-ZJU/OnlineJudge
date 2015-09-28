package cn.edu.zju.coffee.google.codejam.no10214486;

import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import cn.edu.zju.coffee.google.codejam.CodejamUtils;

public class MainB {
	public static void main(String[] args) throws IOException {
		Scanner scanner = CodejamUtils.getScanner("B-large-practice", MainB.class);
		Writer writer = CodejamUtils.getWriter("B-large-practice", MainB.class);
		CodejamUtils.timerStart();
//		Scanner scanner = CodejamIOUtil.getScanner("b-test", MainB.class);
//		Writer writer = CodejamIOUtil.getWriter("b-test", MainB.class);
		
		int t = scanner.nextInt();
		System.out.println(t+" cases total");
		for(int ttt = 0; ttt < t; ttt ++){
			System.out.println("case No. "+ttt);
			writer.write("Case #"+(ttt+1)+":\n");
			int np = scanner.nextInt(), ne = scanner.nextInt(), nt = scanner.nextInt();
			int[] pt = new int[np];
			for(int i = 0; i < np; i++)
				pt[i] = scanner.nextInt();
			
			int[] et = new int[ne];
			for(int i = 0; i < ne; i++)
				et[i] = scanner.nextInt();
			
			int[] tt = new int[nt];
			for(int i = 0; i < nt; i++)
				tt[i] = scanner.nextInt();
			
			Bike bike = new Bike(pt, et, tt);
			bike.calc();
			
			int q = scanner.nextInt();
			for(int i = 0; i < q; i++)
				writer.write(bike.query(scanner.nextInt(), scanner.nextInt()) ? "Yes\n" : "No\n");
		}
		
		CodejamUtils.timerStop();
		scanner.close();
		writer.close();
	}
}

class RatioPair{
	long p;
	long q;
	
	static long gcd(long m, long n) {   
        while (m % n != 0) {   
        	long temp = m % n;   
            m = n;   
            n = temp;   
        }   
        return n;   
    }   
	
	public RatioPair(long p, long q) {
		long gcd = gcd(p,q);
		
		this.p = p / gcd;
		this.q = q / gcd;
	}

	@Override
	public boolean equals(Object o){
		if(!(o instanceof RatioPair))
			return false;
		
		RatioPair other = (RatioPair) o;
		return p == other.p && q == other.q;
	}
	
	@Override
	public int hashCode(){
		return (p+" "+q).hashCode();
	}

	@Override
	public String toString() {
		return "RatioPair [p=" + p + ", q=" + q + "]";
	}
	
}

class Bike{
	int[] pTeeth;
	int[] eTeeth;
	int[] tTeeth;
	
	Set<RatioPair> ratioPairs;
	
	public Bike(int[] pTeeth, int[] eTeeth, int[] tTeeth) {
		this.pTeeth = pTeeth;
		this.eTeeth = eTeeth;
		this.tTeeth = tTeeth;
	}

	void calc(){
		ratioPairs = new HashSet<RatioPair>();
//		Set<RatioPair> extraPairs = new HashSet<RatioPair>();
//		Set<RatioPair> ptPairs = new HashSet<RatioPair>();
		for(int i = 0; i < eTeeth.length; i++){
			for(int j = 0; j < eTeeth.length; j++){
				if(i == j) continue;
				ratioPairs.add(new RatioPair(eTeeth[i], eTeeth[j]));
			}
		}
//		System.out.println("ratioPairs: "+ratioPairs);
		
//		for(int i = 0; i < pTeeth.length; i++){
//			for(int j = 0; j < tTeeth.length; j++){
//				ptPairs.add(new RatioPair(pTeeth[i], tTeeth[j]));
//			}
//		}
//		
//		for(RatioPair rp1 : ptPairs){
//			for(RatioPair rp2 : extraPairs)
//				ratioPairs.add(new RatioPair(rp1.p*rp2.p, rp1.q*rp2.q));
//		}
	}
	
	boolean query(int p, int q){
		for(int i = 0; i < pTeeth.length; i++){
			for(int j = 0; j < tTeeth.length; j++){
				RatioPair rp = new RatioPair(p, q);
				
				rp = new RatioPair(rp.p*tTeeth[j], rp.q*pTeeth[i]);
//				System.out.println("query: "+rp);
				if(ratioPairs.contains(rp))
					return true;
			}
		}
		return false;
	}
}