package leetcode._2ndtime.no099;

import leetcode.TreeNode;

/**
 * Whiteboard coding!
 *
 */
public class Solution {
    private TreeNode first, second, prev;
    public void recoverTree(TreeNode root) {
        first = second = prev = null;
        visit(root);
        if (first != null) {
            int val = first.val;
            first.val = second.val;
            second.val = val;
        }
    }

    private void findPair(TreeNode n1, TreeNode n2) {
        second = n2;
        if (first == null) {
            first = n1;
        }
    }

    private void visit(TreeNode node) {
        if (node == null) return;
        visit(node.left);
        if (prev != null && node.val <= prev.val) {
            findPair(prev, node);
        }
        prev = node;
        visit(node.right);
    }
}
