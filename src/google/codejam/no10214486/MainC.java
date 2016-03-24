package google.codejam.no10214486;

import google.codejam.CodejamUtils;

import java.io.IOException;
import java.io.Writer;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MainC {
	private List<BigInteger> primes;
	private static final BigInteger ONE = BigInteger.valueOf(1), ZERO = BigInteger.valueOf(0);
	
	public MainC() {
		primes = new LinkedList<BigInteger>();
		primes.add(BigInteger.valueOf(2));
	}
	
	private List<BigInteger> facts(BigInteger bi){
		List<BigInteger> facts = new LinkedList<BigInteger>();
		
		for(BigInteger p: primes){
			if(bi.equals(ONE))
				return facts;
			if(! bi.remainder(p).equals(ZERO))
				continue;
			
			int exp = 0;
			for(; bi.remainder(p).equals(ZERO); exp ++)
				bi = bi.divide(p);
			facts.add(p.pow(exp));
		}
		
//		if(bi.equals(ONE))
//			return facts;
		
		BigInteger lastPrime = primes.get(primes.size() - 1);
		BigInteger nextPrime;
		while(! bi.equals(ONE)){
			nextPrime = lastPrime.nextProbablePrime();
			primes.add(nextPrime);
			lastPrime = nextPrime;
			
			if(! bi.remainder(nextPrime).equals(ZERO))
				continue;
			int exp = 0;
			for(; bi.remainder(nextPrime).equals(ZERO); exp ++)
				bi = bi.divide(nextPrime);
			facts.add(nextPrime.pow(exp));
		}
		
		return facts;
	}
	
	private boolean isGNumber(BigInteger bi){
		if(bi.equals(ONE))
			return true;
		
		char[] biChars = bi.toString().toCharArray();
		int sum = 0;
		for(char c: biChars)
			sum += (c - '0');
		
		return BigInteger.valueOf(sum).isProbablePrime(Integer.MAX_VALUE);
	}
	
	public static void main(String[] args) throws IOException {
//		MainC mc = new MainC();
//		System.out.println(mc.isGNumber(BigInteger.valueOf(8)));
//
//		for(int i = 1; i <= 50; i++)
//			System.out.println(mc.facts(BigInteger.valueOf(i)));


		MainC mc = new MainC();
		Scanner scanner = CodejamUtils.getScanner(fileName, MainC.class);
		Writer writer = CodejamUtils.getWriter(fileName, MainC.class);
		int t = scanner.nextInt();
		for(int tt = 0; tt < t; tt++){
			int[] res = mc.facts(new BigInteger(scanner.next()));
			int a = res[0], b = res[1];
			if (((a+b) % 2 == 1 && a < b) ||
					((a+b) % 2 == 0 && a>=b))
				writer.write(String.format("Case #%d: Laurence\n", tt+1));
			else
				writer.write(String.format("Case #%d: Seymour\n", tt+1));
		}

		scanner.close();
		writer.close();
	}
}

