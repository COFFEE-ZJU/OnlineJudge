package leetcode._1sttime.no110;

import leetcode.TreeNode;

public class Solution {

    public boolean isBalanced(TreeNode root) {
        return depth(root) != null;
    }

    private Integer depth(TreeNode node) {
        if (node == null) return 0;
        Integer left = depth(node.left);
        if (left == null) return null;
        Integer right = depth(node.right);
        if (right == null) return null;

        return Math.abs(left-right) <= 1 ? Math.max(left,right) + 1 : null;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
    }
}