package cn.edu.zju.coffee.google.codejam.no10214486;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

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
	
	public static void main(String[] args) {
		MainC mc = new MainC();
		System.out.println(mc.isGNumber(BigInteger.valueOf(8)));
		
		for(int i = 1; i <= 50; i++)
			System.out.println(mc.facts(BigInteger.valueOf(i)));
	}
}

