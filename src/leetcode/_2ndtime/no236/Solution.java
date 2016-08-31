package leetcode._2ndtime.no236;

import leetcode.TreeNode;

/**
 * Whiteboard coding!
 */
public class Solution {
    private TreeNode lca, p, q;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca = null;
        this.p = p; this.q = q;
        find(root);
        return lca;
    }

    private int find(TreeNode node) {
        if (node == null || lca != null) return 0;
        int cnt = 0;
        if (node == p || node == q) cnt++;
        cnt = cnt + find(node.left) + find(node.right);
        if (cnt == 2 && lca == null) lca = node;
        return cnt;
    }
}