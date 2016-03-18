package cn.edu.zju.coffee.hiho.no1040;

import java.util.Scanner;

/**
 * 
 * Problem Description: http://hihocoder.com/problemset/problem/1040
 * @author zkf
 *
 */

public class Main {
	private static class Line {
		final int x0, y0, x1, y1, dx, dy;

		private Line(int x0, int y0, int x1, int y1) {
			this.x0 = x0;
			this.y0 = y0;
			this.x1 = x1;
			this.y1 = y1;
			dx = x1-x0;
			dy = y1-y0;
		}

		private boolean isVertAndContinous(Line l) {
			if (dx * l.dx + dy * l.dy != 0) return false;
			return (x0 == l.x0 && y0 == l.y0) ||
					(x0 == l.x1 && y0 == l.y1) ||
					(x1 == l.x0 && y1 == l.y0) ||
					(x1 == l.x1 && y1 == l.y1);
		}

		private boolean isLegalLine() {
			return dx != 0 || dy != 0;
		}
	}

	private boolean isRect(Line[] lines) {
		for (int i = 0; i < 4; i++) {
			Line cur = lines[i];
			if (!cur.isLegalLine())
				return false;
			int vertCnt = 0;
			for (Line l : lines) {
				if (l != cur && l.isVertAndContinous(cur))
					vertCnt++;
			}
			if (vertCnt != 2)
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		Main main = new Main();

		try(Scanner scanner = new Scanner(System.in)) {
			int r = scanner.nextInt();
			Line[] lines = new Line[4];
			for (int rr = 0; rr < r; rr++) {
				for (int i = 0; i < 4; i++)
					lines[i] = new Line(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
				System.out.println(main.isRect(lines) ? "YES" : "NO");
			}
		}
	}
}
