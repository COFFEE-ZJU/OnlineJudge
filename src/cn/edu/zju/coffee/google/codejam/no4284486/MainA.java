package cn.edu.zju.coffee.google.codejam.no4284486;

import java.io.IOException;
import java.io.Writer;
import java.math.BigInteger;
import java.util.Scanner;

import cn.edu.zju.coffee.google.codejam.CodejamUtils;

public class MainA {
	
	public static void test(){
		GoogolString gs = new GoogolString(18);
		for(int i = 0; i < 10; i++){
			System.out.print(gs.kthBit(BigInteger.valueOf(i+1)));
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner scanner = CodejamUtils.getScanner("A-large-practice", MainA.class);
		Writer writer = CodejamUtils.getWriter("A-large-practice", MainA.class);
		
		GoogolString gs = new GoogolString(18);
		int t = scanner.nextInt();
		for(int tt = 0; tt < t; tt++){
			BigInteger k = new BigInteger(scanner.next());
			writer.write(String.format("Case #%d: %d\n", tt+1, gs.kthBit(k)));
		}
		
		scanner.close();
		writer.close();
		
//		test();
	}
}

class GoogolString{
	int N = 0;
	BigInteger len = BigInteger.ONE;
	
	GoogolString(int maxExp){
		BigInteger maxK = BigInteger.valueOf(10);
		maxK = maxK.pow(18);
		while(maxK.compareTo(len) == 1){
			N++;
			len = len.shiftLeft(1);
		}
//		System.out.println(N);
	}
	
	int kthBit(BigInteger k){
		BigInteger curLen = len;
		BigInteger mid;
		boolean rev = false, found = false;
		while(! k.equals(BigInteger.ONE) && ! found){
			mid = curLen.shiftRight(1);
			
			switch (k.compareTo(mid)) {
			case 0:		//k == mid
				found = true;
				break;
			case 1:		//k > mid
				k = curLen.subtract(k);
				rev = !rev;
				break;
			case -1:	//k < mid
			default:
				break;
			}
			
			curLen = mid;
		}
		
		return rev ? 1 : 0;
	}
}