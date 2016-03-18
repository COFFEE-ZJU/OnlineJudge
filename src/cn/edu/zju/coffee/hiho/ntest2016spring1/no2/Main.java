package cn.edu.zju.coffee.hiho.ntest2016spring1.no2;

import java.util.*;

public class Main {
	private static class Node implements Comparable<Node> {
		List<Node> depends = new LinkedList<>();
		List<Node> depended = new LinkedList<>();
		int id;
		String name;
		Node(int id) {
			this.id = id;
		}

		@Override
		public int compareTo(Node o) {
			return name.compareTo(o.name);
		}
	}
	
	public static void main(String[] args) {

		try(Scanner scanner = new Scanner(System.in)) {
			int r = scanner.nextInt();
			for (int rr = 0; rr < r; rr++) {
				int n = scanner.nextInt();
				Node[] nodes = new Node[n];
				for (int i = 0; i < n; i++)
					nodes[i] = new Node(i);

				for (int i = 0; i < n; i++) {
					Node cur = nodes[i];
					cur.name = scanner.next();
					int m = scanner.nextInt();
					for (int j = 0; j < m; j++) {
						int id = scanner.nextInt();
						cur.depends.add(nodes[id]);
						nodes[j].depended.add(cur);
					}
				}

				TreeSet<Node> indSet = new TreeSet<>();
				for (Node node : nodes) {
					if (node.depends.isEmpty())
						indSet.add(node);
				}

				List<Node> compList = new LinkedList<>();
				while (!indSet.isEmpty()) {
					Node comp = indSet.first();
					indSet.remove(comp);
					compList.add(comp);
					for (Node next : comp.depended) {
						next.depends.remove(comp);
						if (next.depends.isEmpty())
							indSet.add(next);
					}
				}

				if (compList.size() != n)
					System.out.println("ERROR");
				else {
					for (Node node : compList)
						System.out.println(node.name);
				}
				System.out.println();
			}
		}
	}
}
