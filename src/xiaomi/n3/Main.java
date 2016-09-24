package xiaomi.n3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

	private Map<Integer, Integer> lefts = new HashMap<>();
	private Map<Integer, Integer> rights = new HashMap<>();
	private Set<Integer> roots = new HashSet<>();
	private void deal() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {
			int n = scanner.nextInt();
			lefts.clear();
			rights.clear();
			roots.clear();
			for (int i = 0; i < n; i++) {
				roots.add(i);
			}
			for (int i = 0; i < n-1; i++) {
				int p = scanner.nextInt();
				int c = scanner.nextInt();
				roots.remove(c);
				Integer cc = lefts.get(p);
				if (cc == null) lefts.put(p, c);
				else rights.put(p, c);
			}

			System.out.println(getHeight(roots.iterator().next()));
		}
	}

	private int getHeight(Integer root) {
		if (root == null) return 0;
		return Math.max(getHeight(lefts.get(root)), getHeight(rights.get(root))) + 1;
	}

	public static void main(String[] args) {
		new Main().deal();
	}
}
