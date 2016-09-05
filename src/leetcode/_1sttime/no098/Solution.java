package leetcode._1sttime.no098;

import leetcode.TreeNode;

public class Solution {
    private TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        prev = null;
        return traverse(root);
    }

    private boolean traverse(TreeNode node){
        if (node == null)
            return true;

        if (traverse(node.left) == false)
            return false;
        if (prev != null && prev.val >= node.val)
            return false;
        prev = node;
        return traverse(node.right);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isValidBST(TreeNode.genTree(1,null,3,2)));
        System.out.println(sol.isValidBST(TreeNode.genTree(1,null,2,3)));
        System.out.println(sol.isValidBST(TreeNode.genTree(3,1,4,null,2,null,5)));
        System.out.println(sol.isValidBST(TreeNode.genTree(3,5,4,null,2,null,1)));
    }
}