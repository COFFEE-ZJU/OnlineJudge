package hiho.no1272;

import java.util.Scanner;

public class Main {
	final private int[] prices;
	final private int[] satis;
	private int len, max, curPri, curSati;

	public Main(int[] prices, int[] satis) {
		this.prices = prices;
		this.satis = satis;
		len = prices == null ? 0 : prices.length;
	}

	private void incAndUpdate(int i) {
		curPri += prices[i];
		curSati += satis[i];
		if (curPri % 50 == 0)
			max = Math.max(max, curSati);
	}

	private void dec(int i) {
		curPri -= prices[i];
		curSati -= satis[i];
	}

	public int getMaxSatis(){
		if (len == 0) return 0;

		max = curPri = curSati = 0;
		for (int i = 0; i < len; i++) {
			incAndUpdate(i);
			for (int j = i+1; j < len; j++) {
				incAndUpdate(j);
				for (int k = j+1; k < len; k++) {
					incAndUpdate(k);
					dec(k);
				}
				dec(j);
			}
			dec(i);
		}

		return max;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int r = scanner.nextInt();
		for (int rr = 0; rr < r; rr++) {
			int n = scanner.nextInt();
			int[] prices = new int[n];
			int[] satis = new int[n];
			for (int i = 0; i < n; i++) {
				prices[i] = (int)(scanner.nextFloat() * 10);
				satis[i] = scanner.nextInt();
			}

			System.out.println(new Main(prices, satis).getMaxSatis());
		}

		scanner.close();
	}
}
