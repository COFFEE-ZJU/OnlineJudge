package hiho.hihointerview19.n4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author zkf
 *
 */

public class Main {
	private class Point implements Comparable<Point>{
		final int r, c;
		boolean blocked = false;
		long dist = Long.MAX_VALUE;
		boolean visited = false;
		Point prev = null;

		private Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		private void visitNeighbors() {
			if (r != 0)
				visit(street[r-1][c], distN[r-1]);
			if (r != n-1)
				visit(street[r+1][c], distN[r]);
			if (c != 0)
				visit(street[r][c-1], distM[c-1]);
			if (c != m-1)
				visit(street[r][c+1], distM[c]);
		}

		private void visit(Point nbr, int len) {
			if (!nbr.visited && !nbr.blocked && nbr.dist > dist + len) {
				queue.remove(nbr);
				nbr.dist = dist + len;
				nbr.prev = this;
				queue.add(nbr);
			}
		}

		@Override
		public int compareTo(Point o) {
			return Long.compare(dist, o.dist);
		}
	}

	private int n, m;
	private int[] distN, distM;
	private Point[][] street;

	public void deal() {
		try(Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNextInt()) {
				n = scanner.nextInt();
				m = scanner.nextInt();
				distN = new int[n-1];
				distM = new int[m-1];
				for (int i = 0; i < n - 1; i++) {
					distN[i] = scanner.nextInt();
				}
				for (int i = 0; i < m - 1; i++) {
					distM[i] = scanner.nextInt();
				}

				street = new Point[n][m];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						street[i][j] = new Point(i, j);
					}
				}

				int k = scanner.nextInt();
				for (int i = 0; i < k; i++) {
					street[scanner.nextInt()-1][scanner.nextInt() - 1].blocked = true;
				}

				int q = scanner.nextInt();
				for (int i = 0; i < q; i++) {
					System.out.println(minPath(scanner.nextInt()-1, scanner.nextInt()-1,
							scanner.nextInt()-1, scanner.nextInt()-1));
				}
			}
		}
	}

	private static class Query {
		final int stR, stC, endR, endC;

		private Query(int stR, int stC, int endR, int endC) {
			this.stR = stR;
			this.stC = stC;
			this.endR = endR;
			this.endC = endC;
		}

		@Override
		public boolean equals(Object o) {
			Query query = (Query) o;

			if (stR != query.stR) {
				return false;
			}
			if (stC != query.stC) {
				return false;
			}
			if (endR != query.endR) {
				return false;
			}
			return endC == query.endC;

		}

		@Override
		public int hashCode() {
			int result = stR;
			result = 31 * result + stC;
			result = 31 * result + endR;
			result = 31 * result + endC;
			return result;
		}
	}

	private Map<Query, Long> cacheMap = new HashMap<>();
	private PriorityQueue<Point> queue = new PriorityQueue<>();
	private Set<Integer> visited = new HashSet<>();
	private long minPath(int r0, int c0, int r1, int c1) {
		Query q = new Query(r0, c0, r1, c1);
		if (cacheMap.containsKey(q)) {
			return cacheMap.get(q);
		}

		Point start = street[r0][c0], end = street[r1][c1];
		queue.clear();
		visited.clear();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				street[i][j].visited = false;
				street[i][j].dist = Integer.MAX_VALUE;
			}
		}

		start.dist = 0;
		queue.add(start);
		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			cur.visited = true;
			cur.visitNeighbors();
		}

		if (end.dist == Integer.MAX_VALUE)
			return -1;

		List<Point> pathRev = new ArrayList<>();
		for (Point p = end; p != start; p = p.prev) {
			pathRev.add(p);
		}
		pathRev.add(start);
		for (int i = 0; i < pathRev.size() - 1; i++) {
			Point end1 = pathRev.get(i);
			for (int j = i + 1; j < pathRev.size(); j++) {
				Point st1 = pathRev.get(j);
				cacheMap.put(new Query(st1.r, st1.c, end1.r, end1.c), end1.dist - st1.dist);
			}
		}
		return end.dist;
	}

	public static void main(String[] args) {
		new Main().deal();
	}
}
