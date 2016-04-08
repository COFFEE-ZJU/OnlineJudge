package google.codejam.no4284486;

import google.codejam.CodejamUtils;

import java.io.IOException;
import java.io.Writer;
import java.util.*;

public class MainD {
	static class Position{
		final int x, y;

		Position(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Position position = (Position) o;

			if (x != position.x) return false;
			return y == position.y;
		}

		@Override
		public int hashCode() {
			int result = x;
			result = 100000 * result + y;
			return result;
		}
	}

	private static final String fileName = "D-large-practice";
	private final Set<Position> eaten = new HashSet<>();
	private final Set<Position> bodySet = new HashSet<>();
	private final Queue<Position> bodyQueue = new LinkedList<>();
	private int curTime, curR, curC;
	private int dir;	// 0 : right, 1 : down, 2 : left, 3 : up;
	private int row, col;

	public void solve() throws IOException {
		Scanner scanner = CodejamUtils.getScanner(fileName, MainD.class);
		Writer writer = CodejamUtils.getWriter(fileName, MainD.class);

		int t = scanner.nextInt();
		for(int tt = 0; tt < t; tt++){
			eaten.clear();
			bodyQueue.clear();
			bodySet.clear();
			Position st = new Position(1,1);
			bodySet.add(st);
			bodyQueue.add(st);
			curTime = dir = 0;
			curR = curC = 1;

			int s = scanner.nextInt();
			row = scanner.nextInt();
			col = scanner.nextInt();
			boolean alive = true;
//			System.out.println();
			for (int i = 0; i < s; i++) {
				int nextTurnTime = scanner.nextInt();
				int turn = scanner.next().equals("L") ? -1 : 1;
				if (!alive) continue;

				for (; curTime < nextTurnTime; ) {
					if (!alive) break;

					alive = moveOneStep();
				}

				dir = (dir + turn + 4) % 4;
//				System.out.println("turned to dir : " + dir);
			}

			int repeat = dir % 2 == 0 ? col : row;
			for (int i = 0; i < repeat; i++) {
				if (!alive) break;

				alive = moveOneStep();
			}

			writer.write(String.format("Case #%d: %d\n", tt+1, bodyQueue.size()));
		}

		scanner.close();
		writer.close();
	}

	private boolean moveOneStep() {
		updatePos();
		curTime++;
//		System.out.print(String.format("now(%d) at: (%d, %d)", curTime, curR, curC));
		boolean hasFood = hasFood(curR, curC);
//		System.out.println(", has food: " + hasFood);
		if (!hasFood) {
			Position tail = bodyQueue.poll();
			bodySet.remove(tail);
		}
		return addHead();
	}

	private boolean addHead() {
		Position head = new Position(curR, curC);
		bodyQueue.add(head);
		return bodySet.add(head);
	}

	private void updatePos() {
		switch (dir) {
			case 0 : curC++; break;
			case 1 : curR++; break;
			case 2 : curC--; break;
			case 3 : curR--; break;
		}
		if (curR == 0) curR = row;
		else if (curR > row) curR = 1;
		if (curC == 0) curC = col;
		else if (curC > col) curC = 1;
	}

	private boolean hasFood(int i, int j) {
		if ((i + j) % 2 == 0)
			return false;

		return eaten.add(new Position(i, j));
	}

	public static void main(String[] args) throws IOException {
		new MainD().solve();
	}
}

