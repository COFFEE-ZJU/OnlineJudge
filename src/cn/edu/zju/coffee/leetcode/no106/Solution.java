package cn.edu.zju.coffee.leetcode.no106;

import cn.edu.zju.coffee.leetcode.TreeNode;

public class Solution {
    private int[] postorder, inorder;
    private int pi, ii;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null)
            return null;
        if (postorder.length != inorder.length)
            throw new IllegalStateException();

        this.postorder = postorder;
        this.inorder = inorder;
        ii = pi = postorder.length-1;

        return build(null);
    }

    private TreeNode build(TreeNode revInorderNext){
        if (pi < 0 || ii < 0)
            return null;
        if (revInorderNext != null && inorder[ii] == revInorderNext.val) {
            ii--;
            return null;
        }
        TreeNode node = new TreeNode(postorder[pi--]);
        node.right = build(node);
        node.left = build(revInorderNext);
        return node;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.buildTree(new int[]{1,4,3,5}, new int[]{4,5,3,1}));
        System.out.println(sol.buildTree(new int[]{1,2,3,4,5}, new int[]{2,1,5,4,3}));
    }
}