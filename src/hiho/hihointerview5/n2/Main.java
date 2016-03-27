package hiho.hihointerview5.n2;

import java.util.Scanner;

/**
 * 
 * Problem Description: http://hihocoder.com/contest/msinterntest/problem/1
 * @author zkf
 *
 */

public class Main {
	public void deal() {
		StringBuilder sb = new StringBuilder();
		try(Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNextLong()) {
				long a = scanner.nextLong();
				long b = scanner.nextLong();
				calc(a, b);
			}
		}
	}

	private void calc(long a, long b) {
		long gcd = gcd(a, b);
		int acnt, bcnt, gcnt;
		long asqrt = (long)Math.sqrt(a), bsqrt = (long)Math.sqrt(b);
		long gcdsqrt = (long)Math.sqrt(gcd);
		gcnt = 0;
		for (long i = 1; i <= gcdsqrt; i++) {
			if (gcd % i == 0) gcnt+=2;
		}
		if (gcdsqrt * gcdsqrt == gcd) gcnt--;

		acnt = bcnt = 0;
		for (long i = 1; i <= asqrt; i++) {
			if (a % i == 0) acnt+=2;
		}
		for (long i = 1; i <= bsqrt; i++) {
			if (b % i == 0) bcnt+=2;
		}
		if (bsqrt * bsqrt == b) bcnt--;
		if (asqrt * asqrt == a) acnt--;

		long den = acnt * bcnt;
		long ggcd = gcd(den, gcnt);
		System.out.println(den/ggcd + " " + (gcnt/ggcd));
	}

	private long gcd(long a, long b) {
		if (b == 0) return a;

		return gcd(b, a % b);
	}
	
	public static void main(String[] args) {
		new Main().deal();
	}
}
