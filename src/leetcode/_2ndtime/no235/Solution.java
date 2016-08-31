package leetcode._2ndtime.no235;

import leetcode.TreeNode;

/**
 * Whiteboard coding!
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) return root;

        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);

        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);

        return root;
    }
}