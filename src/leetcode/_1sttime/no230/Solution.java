package leetcode._1sttime.no230;

import leetcode.TreeNode;

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) throw new NullPointerException();
        return find(root, k);
    }

    private int count(TreeNode node) {
        if (node == null) return 0;

        return count(node.left) + count(node.right) + 1;
    }

    private int find(TreeNode node, int k) {
        int cntLeft = count(node.left);
        if (cntLeft == k-1) return node.val;
        if (cntLeft > k-1) return find(node.left, k);
        else return find(node.right, k-1-cntLeft);
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
    }
}
