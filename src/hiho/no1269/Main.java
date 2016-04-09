package hiho.no1269;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	private static Comparator<Integer> comp = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return Integer.compare(o2, o1);
		}
	};
	private static PriorityQueue<Integer> heap = new PriorityQueue<Integer>(100000, comp);

	public static void solve(int[] ps, long thr) {
		int low = 1, high = ps.length;
		boolean solvable = false;
		while (low <= high) {
			int mid = (low + high) / 2;
			heap.clear();
			int i;
			long sp = 0, cnt = 1;
			for (i = 0; i < mid; i++) {
				heap.add(ps[i]);
			}
			for (; i < ps.length; i++) {
				sp += heap.poll() * (cnt++);
				heap.add(ps[i]);
			}
			while (!heap.isEmpty()) {
				sp += heap.poll() * (cnt++);
			}

			if (sp <= thr) {
				high = mid - 1;
				solvable = true;
			}
			else
				low = mid+1;
		}

		System.out.println(solvable ? low : -1);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {
			int n = scanner.nextInt();
			long q = scanner.nextLong();
			int[] ps = new int[n];
			for (int i = 0; i < n; i++) {
				ps[i] = scanner.nextInt();
			}
			solve(ps, q);
		}

		scanner.close();
	}
}
