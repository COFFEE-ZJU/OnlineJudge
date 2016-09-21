package douban.n1;

public class Main {
	private static class TreeNode {
		TreeNode left, right;
		int val;
	}

	private int cnt;
	public int countSwap(TreeNode root) {
		if (root == null) return 0;
		cnt = 0;

		visit(root, 0);

		return cnt;
	}

	private void visit(TreeNode node, int level) {
		if (node == null) return;
		if (level % 2 == 0 && (node.left != null || node.right != null)) {
			cnt++;
			TreeNode tmp = node.left;
			node.left = node.right;
			node.right = tmp;
		}
		visit(node.left, level+1);
		visit(node.right, level+1);
	}
}
