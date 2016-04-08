package google.codejam.no10214486;

import google.codejam.CodejamUtils;

import java.io.IOException;
import java.io.Writer;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MainC {
	private List<Long> primes;
	private static final BigInteger ONE = BigInteger.valueOf(1), ZERO = BigInteger.valueOf(0);
	
	public MainC() {
		primes = new LinkedList<>();
		primes.add(2l);
	}
	
	private List<Long> facts(long bi){
		List<Long> facts = new ArrayList<>();
		
		for(long p: primes){
			if(bi == 1l)
				return facts;
			if(bi % p != 0)
				continue;
			
			int exp = 0;
			long fact = 1;
			for(; bi % p == 0; exp++) {
				bi /= p;
				fact *= p;
			}
			if (exp > 0)
				facts.add(fact);
		}

		BigInteger lastPrime = BigInteger.valueOf(primes.get(primes.size() - 1));
		BigInteger nextPrime;
		long sqrt = (long)Math.floor(Math.sqrt(bi));
		if (lastPrime.longValue() > sqrt || BigInteger.valueOf(bi).isProbablePrime(Integer.MAX_VALUE)) {
			System.out.println(bi + "is prime");
			facts.add(bi);
			return facts;
		}

		System.out.println("sqrt: " + sqrt);
		while(bi != 1l){
			nextPrime = lastPrime.nextProbablePrime();
			long np = nextPrime.longValue();
			System.out.println("new prime : " + np);
			primes.add(np);
			lastPrime = nextPrime;

			if (np > sqrt) {
				facts.add(bi);
				return facts;
			}

			int exp = 0;
			long fact = 1;
			for(; bi % np == 0; exp++) {
				bi /= np;
				fact *= np;
			}
			if (exp > 0)
				facts.add(fact);
		}
		
		return facts;
	}
	
	private boolean isGNumber(long bi){
		char[] biChars = String.valueOf(bi).toCharArray();
		int sum = 0;
		for(char c: biChars)
			sum += (c - '0');

		BigInteger bsum = BigInteger.valueOf(sum);
		return bsum.equals(ONE) || bsum.isProbablePrime(Integer.MAX_VALUE);
	}

	private boolean canWin(List<Long> factors, long num) {
		if (isGNumber(num))
			return false;
		for (int i = 0; i < factors.size(); i++) {
			Long fact = factors.set(i, null);
			if (fact == null) continue;

			if (!canWin(factors, num / fact)) {
				factors.set(i, fact);
				return true;
			}

			factors.set(i, fact);
		}
		return false;
	}

//	private static final String fileName = "c-test";
	private static final String fileName = "C-large-practice";
//	private static final String fileName = "C-small-practice";
	public static void main(String[] args) throws IOException {
//		MainC mc = new MainC();
//		System.out.println(mc.isGNumber(BigInteger.valueOf(8)));
//
//		for(int i = 1; i <= 50; i++)
//			System.out.println(mc.facts(BigInteger.valueOf(i)));

		System.out.println(31622741l * 31622743l);
		MainC mc = new MainC();
		Scanner scanner = CodejamUtils.getScanner(fileName, MainC.class);
		Writer writer = CodejamUtils.getWriter(fileName, MainC.class);
		int t = scanner.nextInt();
		for(int tt = 0; tt < t; tt++){
			long num = scanner.nextLong();
			System.out.println(num);
			if (mc.isGNumber(num)) {
				writer.write(String.format("Case #%d: Seymour\n", tt+1));
				continue;
			}

			List<Long> factors = mc.facts(num);
			if (mc.canWin(factors, num))
				writer.write(String.format("Case #%d: Laurence\n", tt+1));
			else
				writer.write(String.format("Case #%d: Seymour\n", tt+1));
		}

		scanner.close();
		writer.close();
	}
}

