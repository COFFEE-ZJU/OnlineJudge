package leetcode.no105;

import leetcode.TreeNode;

public class Solution {
    private int[] preorder, inorder;
    private int pi, ii;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null)
            return null;
        if (preorder.length != inorder.length)
            throw new IllegalStateException();

        this.preorder = preorder;
        this.inorder = inorder;
        pi = ii = 0;

        return build(null);
    }

    private TreeNode build(TreeNode inorderNext){
        if (pi >= preorder.length || ii >= inorder.length)
            return null;
        if (inorderNext != null && inorder[ii] == inorderNext.val) {
            ii++;
            return null;
        }
        TreeNode node = new TreeNode(preorder[pi++]);
        node.left = build(node);
        node.right = build(inorderNext);
        return node;
    }

    public TreeNode buildTreeSlow(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null)
            return null;
        if (preorder.length != inorder.length)
            throw new IllegalStateException();

        this.preorder = preorder;
        this.inorder = inorder;

        return build(0, 0, inorder.length);
    }

    private TreeNode build(int ps, int is, int len){
        if (len == 0)
            return null;

        int val = preorder[ps];
        TreeNode node = new TreeNode(val);
        if (len == 1)
            return node;

        int leftLen = 0;
        while (inorder[is+leftLen] != val)
            leftLen++;

        node.left = build(ps+1, is, leftLen);
        node.right = build(ps + leftLen + 1, is + leftLen + 1, len - leftLen - 1);
        return node;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.buildTree(new int[]{1,3,4,5}, new int[]{1,4,3,5}));
        System.out.println(sol.buildTree(new int[]{3,1,2,4,5}, new int[]{1,2,3,4,5}));
    }
}