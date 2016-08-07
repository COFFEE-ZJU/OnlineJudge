package hiho.no1199;

import java.util.Scanner;

public class Main {
	private static class Node {
		final int price, payback;
		Node left, right;

		private Node(int price, int payback) {
			this.price = price;
			this.payback = payback;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {
			int n = scanner.nextInt();
			Node[] nodes = new Node[n];
			for (int i = 0; i < n; i++) {
				nodes[i] = new Node(scanner.nextInt(), scanner.nextInt());
			}
			for (int i = 0; i < n - 1; i++) {
				Node par = nodes[scanner.nextInt()-1];
				Node chi = nodes[scanner.nextInt()-1];
				if (par.left == null) par.left = chi;
				else par.right = chi;
			}

			System.out.println(calc(nodes[0]).price);
		}

		scanner.close();
	}

	private static Node calc(Node node) {
		if (node == null) return new Node(0, 0);
		Node left = calc(node.left);
		Node right = calc(node.right);
        int c1 = costByOrder(left, right);
        int c2 = costByOrder(right, left);
        int cPrice = Math.min(c1, c2);
        int cPayPack = cPrice - left.payback + left.payback - right.price + right.payback;

        int price = node.price;
        int payback = node.payback - cPrice + cPayPack;
        int owe = node.payback - cPrice;
        if (owe < 0) {
            price -= owe;
            payback -= owe;
        }
        return new Node(price, payback);
	}

    private static int costByOrder(Node n1, Node n2) {
        int cost = n1.price;
        int cur = n1.payback;
        cur -= n2.price;
        if (cur < 0) cost -= cur;

        return cost;
    }
}
