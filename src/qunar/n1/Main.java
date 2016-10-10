package qunar.n1;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	private void deal() {
		Scanner scanner = new Scanner(System.in);

		TreeMap<Long, Long> interval = new TreeMap<>();
		interval.put(Long.MIN_VALUE, -1l);
		while (scanner.hasNextLong()) {
			long st = scanner.nextLong();
			long end = scanner.nextLong() + 1;
			long price = scanner.nextLong();
			updateInterval(interval, st, end, price);
		}
		printIntervals(interval);
	}

	private void printIntervals(TreeMap<Long, Long> interval) {
		Long prevK = null, prevV = null;
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Long, Long> ent : interval.entrySet()) {
			long curK = ent.getKey(), curV = ent.getValue();
			if (prevK != null) {
				if (prevV != curV) {
					sb.append(String.format(", [%d, %d, %d]", prevK, curK-1, prevV));
				} else {
					continue;
				}
			}
			if (curV == -1) {
				prevK = prevV = null;
			} else {
				prevK = curK;
				prevV = curV;
			}
		}
		System.out.println(sb.length() == 0 ? "" : sb.substring(2));
	}

	private void updateInterval(TreeMap<Long, Long> interval, long st, long end, long price) {
		long point = interval.floorKey(end);
		interval.put(end, interval.get(point));
		interval.put(st, price);
		for (Long k = interval.higherKey(st); k != null && k < end; k = interval.higherKey(k)){
			interval.remove(k);
		}
	}

	public static void main(String[] args) {
		new Main().deal();
	}
}
