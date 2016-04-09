package hiho.msintern.n2;

import java.util.Scanner;

public class Main {
	private static class Node {
		boolean allow = true;
		Node left, right;	// 0: left, 1: right
	}
	private static class RuleTree {
		Node root = new Node();

		void apply(Rule rule) {
			int mm = 32 - rule.mask;
			int msk = 1 << 31;
			int addr = rule.address;
			Node node = root;
			for (int i = 0; i < mm; i++) {
				if ((addr & msk) == 0) {
					if (node.left == null) {
						node.left = new Node();
						node.left.allow = node.allow;
					}
					node = node.left;
				}
				else {
					if (node.right == null) {
						node.right = new Node();
						node.right.allow = node.allow;
					}
					node = node.right;
				}
				msk >>>= 1;
			}
			node.left = null;
			node.right = null;
			node.allow = rule.allow;
		}

		boolean check(int addr) {
			Node node = root;
			int msk = 1 << 31;
			for (int i = 0; i < 32; i++) {
				if ((addr & msk) == 0) {
					if (node.left == null)
						return node.allow;

					node = node.left;
				}
				else {
					if (node.right == null)
						return node.allow;

					node = node.right;
				}

				msk >>>= 1;
			}

			return node.allow;
		}
	}

	private static class Rule {
		boolean allow;
		int address;
		int mask;

		Rule(String all, String addr) {
			if ("allow".equals(all))
				allow = true;
			else
				allow = false;

			if (addr.indexOf('/') == -1) {
				mask = 0;
				address = addrToLong(addr);
			}
			else {
				String[] ss = addr.split("/");
				address = addrToLong(ss[0]);
				mask = 32 - Integer.valueOf(ss[1]);
			}

			address = (address >>> mask) << mask;
		}

		public boolean matches(int addr) {
			if (mask == 32) return true;
			return (address >>> mask) == (addr >>> mask);
		}

		public boolean matches(String addr) {
			return matches(addrToLong(addr));
		}

		static int addrToLong(String addr) {
			String[] ss = addr.split("\\.");
			int address = 0;
			for (String s : ss) {
				address = address << 8;
				address += Integer.valueOf(s);
			}

			return address;
		}

		@Override
		public String toString() {
			return "Rule{" +
					"allow=" + allow +
					", address=" + address +
					", mask=" + mask +
					'}';
		}
	}
	public void deal() {

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			Rule[] rules = new Rule[n];

			for (int i = 0; i < n; i++) {
				rules[i] = new Rule(scanner.next(), scanner.next());
			}

			RuleTree tree = new RuleTree();
			for (int i = n-1; i >= 0; i--) {
				tree.apply(rules[i]);
			}

			for (int i = 0; i < m; i++) {
				int addr = Rule.addrToLong(scanner.next());

				System.out.println(tree.check(addr) ? "YES" : "NO");
			}
		}
	}

	public static void main(String[] args) {
		new Main().deal();
	}
}
