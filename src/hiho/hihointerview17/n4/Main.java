package hiho.hihointerview17.n4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author zkf
 *
 */

public class Main {
	private static class Point {
		final int x, y;

		private Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		private double dist(Point o) {
			return Math.sqrt((x - o.x) * (x - o.x) + (y - o.y) * (y - o.y));
		}
	}
	private int n,m;
	private double maxArea;
	private Point[] points;

	public void deal() {
		try(Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNextInt()) {
				n = scanner.nextInt();
				m = scanner.nextInt();
				points = new Point[n];
				maxArea = 0;
				for (int i = 0; i < n; i++) {
					int x = scanner.nextInt();
					int y = scanner.nextInt();
					points[i] = new Point(x, y);
				}
				if (m <= 2) System.out.println(0);
				else {
					rec(0, m, new ArrayList<>());
					System.out.println(maxArea);
				}
			}
		}
	}

	private double _3Area(Point p1, Point p2, Point p3) {
		double a = p1.dist(p2), b = p1.dist(p3), c = p2.dist(p3);
		double s = (a+b+c) / 2;
		return Math.sqrt(s*(s-a)*(s-b)*(s-c));
	}

	private void rec(int i, int rem, List<Point> selected) {
		if (rem == 0) calc(selected);
		for (int j = i; j < n; j++) {
			selected.add(points[i]);
			rec(i+1, rem-1, selected);
			selected.remove(selected.size()-1);
			rec(i+1, rem, selected);
		}
	}

	private void calc(List<Point> selected) {
		if (selected.size() == 3) {
			maxArea = Math.max(maxArea, _3Area(selected.get(0), selected.get(1), selected.get(2)));
		}
	}

	public static void main(String[] args) {
		new Main().deal();
	}
}
