package leetcode._1sttime.no129;

import leetcode.TreeNode;

public class Solution {
	private int sum;

	public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;
		sum = 0;

		calcInfo(root, 0);
		return sum;
	}

	private void calcInfo(TreeNode node, int parent){
		int newP = parent * 10 + node.val;

		if (node.left == null && node.right == null) {
			sum += newP;
			return;
		}

		if (node.left != null)
			calcInfo(node.left, newP);
		if (node.right != null)
			calcInfo(node.right, newP);
	}

    public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.sumNumbers(TreeNode.genTree(1,2,3)));
		System.out.println(sol.sumNumbers(TreeNode.genTree(1,null,3)));
	}
}