package hiho.hihointerview17.n2_2;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author zkf
 *
 */

public class Main {
	private static class Potential implements Comparable<Potential>{
		double c;
		final double b;
		double pot;

		private Potential(double c, double b) {
			this.c = c;
			this.b = b;
			pot = Math.pow((c+1) / c, b);
		}

		private double getScore() {
			return Math.pow(c, b);
		}

		private void incC() {
			c++;
			pot = Math.pow((c+1) / c, b);
		}

		@Override
		public int compareTo(Potential o) {
			return Double.compare(o.pot, pot);
		}
	}

	private int k,n;
	private int[] a;
	private double[] b;

	public void deal() {
		try(Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNextInt()) {
				n = scanner.nextInt();
				k = scanner.nextInt();
				a = new int[k];
				b = new double[k];
				for (int i = 0; i < k; i++) {
					a[i] = scanner.nextInt();
				}
				for (int i = 0; i < k; i++) {
					b[i] = 1.0 / scanner.nextInt();
				}

				System.out.println(maxScore());
			}
		}
	}

	private double maxScore() {
		PriorityQueue<Potential> heap = new PriorityQueue<>();
		for (int i = 0; i < k; i++) {
			heap.add(new Potential(a[i], b[i]));
		}
		for (int i = 0; i < n; i++) {
			Potential pot = heap.poll();
			pot.incC();
			heap.add(pot);
		}

		double score = 1;
		for (Potential pot : heap) {
			score *= pot.getScore();
		}
		return score;
	}

	public static void main(String[] args) {
		new Main().deal();
	}
}
