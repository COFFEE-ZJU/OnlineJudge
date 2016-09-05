package leetcode._1sttime.no236;

import leetcode.TreeNode;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;

        if (root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q),
                right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        if (left == null) return right;
        else return left;
    }

    public static void main(String[] args) {
		Solution sol = new Solution();

    }
}
