package leetcode._2ndtime.no226;

import leetcode.TreeNode;

/**
 * Whiteboard coding!
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }
}