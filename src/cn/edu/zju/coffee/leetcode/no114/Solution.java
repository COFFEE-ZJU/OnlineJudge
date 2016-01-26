package cn.edu.zju.coffee.leetcode.no114;

import cn.edu.zju.coffee.leetcode.TreeNode;

public class Solution {
    private TreeNode prev;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        prev = null;
        addAll(root);
    }

    private void addAll(TreeNode node) {
        if (node == null)
            return;
        if (prev != null)
            prev.right = node;
        prev = node;

        addAll(node.left);
        addAll(node.right);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode node = TreeNode.genTree(1,2,5,3,4,null,6);
        sol.flatten(node);
        System.out.println(node);
    }
}