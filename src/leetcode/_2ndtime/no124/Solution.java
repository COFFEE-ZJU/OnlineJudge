package leetcode._2ndtime.no124;

import leetcode.TreeNode;

/**
 * Whiteboard coding!
 *
 */
public class Solution {
    private int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        findMax(root);
        return max;
    }

    private int findMax(TreeNode node) {
        if (node == null) return 0;
        int left = findMax(node.left);
        int right = findMax(node.right);
        max = Math.max(max, left+right+node.val);
        return Math.max(Math.max(left, right) + node.val, 0);
    }
}
