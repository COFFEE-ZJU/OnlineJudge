package leetcode._2ndtime.no337;

import leetcode.TreeNode;

/**
 * Whiteboard coding!
 *
 */
public class Solution {
    private static final int[] ZEROS = new int[]{0,0};
    public int rob(TreeNode root) {
        return calc(root)[1];
    }

    private int[] calc(TreeNode node) {
        if (node == null) return ZEROS;
        int[] left = calc(node.left);
        int[] right = calc(node.right);
        int[] res = new int[2];
        res[0] = left[1] + right[1];
        res[1] = Math.max(node.val + left[0] + right[0], res[0]);
        return res;
    }
}
