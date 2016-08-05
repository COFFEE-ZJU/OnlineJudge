package leetcode.no101;

import leetcode.TreeNode;

/**
 * Whiteboard coding!
 *
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return (root == null || isSym(root.left, root.right));
    }

    private boolean isSym(TreeNode n1, TreeNode n2) {
        if (n1 == n2) return true;
        if (n1 == null || n2 == null) return false;
        return (n1.val == n2.val && isSym(n1.left, n2.right) && isSym(n1.right, n2.left));
    }
}
