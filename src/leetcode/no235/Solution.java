package leetcode.no235;

import leetcode.TreeNode;

/**
 * Whiteboard coding!
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) return lowestCommonAncestor(root, q, p);

        if (root == null) return null;
        if (root == p || root == q) return root;

        if (p.val < root.val && q.val > root.val) return root;
        if (q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        else return lowestCommonAncestor(root.right, p, q);
    }
}
