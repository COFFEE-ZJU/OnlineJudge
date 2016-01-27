package cn.edu.zju.coffee.leetcode.no124;

import cn.edu.zju.coffee.leetcode.TreeNode;

public class Solution {
    private int max;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        if (root == null)
            return max;

        findMaxToRoot(root);

        return max;
    }

    private int findMaxToRoot(TreeNode node){
        if (node == null)
            return 0;

        int left = findMaxToRoot(node.left), right = findMaxToRoot(node.right);
        if (left < 0) left = 0;
        if (right < 0) right = 0;
        int testMax = left + right + node.val;
        if (testMax > max) max = testMax;
        return Math.max(node.val, Math.max(left + node.val, right + node.val));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxPathSum(TreeNode.genTree(1,2,3)));
        System.out.println(sol.maxPathSum(TreeNode.genTree(1,-2,3)));
        System.out.println(sol.maxPathSum(TreeNode.genTree(-3,-1,-2)));
    }
}