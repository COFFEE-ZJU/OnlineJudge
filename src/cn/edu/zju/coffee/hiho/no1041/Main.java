package cn.edu.zju.coffee.hiho.no1041;

import java.util.*;

/**
 * 
 * Problem Description: http://hihocoder.com/problemset/problem/1041
 * @author zkf
 *
 */

public class Main {
	private static class Node {
		final int id;
		final Set<Node> adjs = new HashSet<>();

		private Node(int id) {
			this.id = id;
		}

		private void addAdj(Node node) {
			adjs.add(node);
			node.adjs.add(this);
		}
	}

	final private Node root;
	final private int[] order;
	Set<Integer> postCities = new HashSet<>();
	Stack<Node> cityPath = new Stack<>();

	public Main(Node root, int[] order) {
		this.root = root;
		this.order = order;
	}

	private boolean isLegalOrder() {
		Node cur = root;
		for (int i = 0; i < order.length; i++) {
			cityPath.clear();
			cur = findAndErasePath(cur, order[i]);
			if (cur == null) return false;
		}

		return true;
	}

	private Node findAndErasePath(Node cur, int target) {
		if (cur.id == target) {
			Node prev = cur;
			while (!cityPath.isEmpty()) {
				Node c = cityPath.pop();
				c.adjs.remove(prev);
				prev = c;
			}
			return cur;
		}
		Node parent = cityPath.isEmpty() ? null : cityPath.peek();
		cityPath.push(cur);
		for (Node city : cur.adjs) {
			if (city == parent) continue;
			Node res = findAndErasePath(city, target);
			if (res != null)
				return res;
		}
		cityPath.pop();
		return null;
	}

	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)) {
			int r = scanner.nextInt();
			for (int rr = 0; rr < r; rr++) {
				int n = scanner.nextInt();
				Node[] nodes = new Node[n];
				for (int i = 0; i < n; i++)
					nodes[i] = new Node(i);
				for (int i = 0; i < n - 1; i++) {
					int c1 = scanner.nextInt()-1, c2 = scanner.nextInt()-1;
					nodes[c1].addAdj(nodes[c2]);
				}
				int[] order = new int[scanner.nextInt()];
				for (int i = 0; i < order.length; i++)
					order[i] = scanner.nextInt()-1;

				System.out.println(new Main(nodes[0], order).isLegalOrder() ? "YES" : "NO");
			}
		}
	}
}
