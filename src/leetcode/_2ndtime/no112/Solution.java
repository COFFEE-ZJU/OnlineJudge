package leetcode._2ndtime.no112;

import leetcode.TreeNode;

/**
 * Whiteboard coding!
 *
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        int ss = sum - root.val;
        if (root.left == null && root.right == null) return ss == 0;
        if (root.left != null && hasPathSum(root.left, ss)) return true;
        if (root.right != null && hasPathSum(root.right, ss)) return true;
        return false;
    }
}
