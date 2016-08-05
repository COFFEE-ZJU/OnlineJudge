package leetcode._2ndtime.no098;

import leetcode.TreeNode;

/**
 * Whiteboard coding!
 *
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode node, Integer left, Integer right) {
        if (node == null) return true;
        int val = node.val;
        if (left != null && val <= left) return false;
        if (right != null && val >= right) return false;
        return isValid(node.left, left, val) && isValid(node.right, val, right);
    }
}
