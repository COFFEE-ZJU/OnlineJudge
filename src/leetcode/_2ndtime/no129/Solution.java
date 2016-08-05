package leetcode._2ndtime.no129;

import leetcode.TreeNode;

/**
 * Whiteboard coding!
 *
 */
public class Solution {
    private int sum;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        sum = 0;
        calc(root, 0);
        return sum;
    }

    private void calc(TreeNode node, int prev) {
        int cur = prev * 10 + node.val;
        if (node.left == null && node.right == null) {
            sum += cur;
            return;
        }

        if (node.left != null) calc(node.left, cur);
        if (node.right != null) calc(node.right, cur);
    }
}
