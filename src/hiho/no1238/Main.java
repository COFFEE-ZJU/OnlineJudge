package hiho.no1238;

import java.util.*;

public class Main {
	private static class Edge {
		final Node n1, n2;
		int dist, split;

		private Edge(Node n1, Node n2, int dist) {
			this.n1 = n1;
			this.n2 = n2;
			this.dist = dist;
		}
	}

	private static class Node {
		final int id;
		Map<Node, Edge> edges = new HashMap<Node, Edge>();
		int tmpCnt = 0;

		private Node(int id) {
			this.id = id;
		}
	}

	private Long getRoadKey(long u, long v) {
		return Math.min(u,v) * n + Math.max(u,v);
	}

	private int n, m;
	public void solve() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {
			n = scanner.nextInt();
			m = scanner.nextInt();
			Node[] cities = new Node[n];
			Map<Long, Edge> roadMap = new HashMap<Long, Edge>();

			for (int i = 0; i < n; i++) {
				cities[i] = new Node(i);
			}
			for (int i = 0; i < n - 1; i++) {
				int u = scanner.nextInt()-1, v = scanner.nextInt()-1, k = scanner.nextInt();
				Node c1 = cities[u], c2 = cities[v];
				Edge road = new Edge(c1, c2, k);
				c1.edges.put(c2, road);
				c2.edges.put(c1, road);
				roadMap.put(getRoadKey(u,v), road);
			}

			List<Node> cityToDeal = new LinkedList<Node>();
			for (Node c : cities) {
				if (c.edges.size() == 1)
					cityToDeal.add(c);
			}

			while (!cityToDeal.isEmpty()) {
				Node city = cityToDeal.remove(0);
				for (Map.Entry<Node, Edge> ent : city.edges.entrySet()) {
					Node other = ent.getKey();
					other.edges.remove(city);
					other.tmpCnt++;
					if (other.edges.size() == 1)
						cityToDeal.add(other);

					Edge road = ent.getValue();
					road.split = city.tmpCnt + 1;
				}

				city.edges.clear();
			}

			long total = 0;
			for (Edge road : roadMap.values()) {
				long s1 = road.split, s2 = n - s1;
				total += s1 * s2 * road.dist;
			}

			for (int i = 0; i < m; i++) {
				String type = scanner.next();
				if (type.equals("QUERY")) {
					System.out.println(total);
					continue;
				}

				int u = scanner.nextInt()-1, v = scanner.nextInt()-1;
				int k = scanner.nextInt();
				Edge road = roadMap.get(getRoadKey(u,v));
				long s1 = road.split, s2 = n - s1;
				total += s1 * s2 * (k - road.dist);
				road.dist = k;
			}
		}

	}

	public static void main(String[] args) {
		new Main().solve();
	}
}
