package cn.edu.zju.coffee.leetcode.no099;

import cn.edu.zju.coffee.leetcode.TreeNode;

public class Solution {
    private TreeNode first, firstNext, prev, second;
    public void recoverTree(TreeNode root) {
        if (root == null)
            return;

        first = firstNext = prev = second = null;
        traverse(root);
        if (first == null)
            throw new IllegalStateException();

        if (second != null)
            return;

        int tmp = first.val;
        first.val = firstNext.val;
        firstNext.val = tmp;
        return;
    }

    private void traverse(TreeNode node){
        if (node == null)
            return;

        traverse(node.left);
        if (prev != null) {
            if (prev.val > node.val){
                if (first == null){
                    first = prev;
                    firstNext = node;
                }
                else if (second == null){
                    second = node;
                    int tmp = first.val;
                    first.val = second.val;
                    second.val = tmp;
                    return;
                }
                else
                    throw new IllegalStateException();
            }
        }
        prev = node;
        traverse(node.right);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode tree = TreeNode.genTree(1,null,2,3);
        sol.recoverTree(tree);
        System.out.println(tree);

        tree = TreeNode.genTree(3,5,4,null,2,null,1);
        sol.recoverTree(tree);
        System.out.println(tree);
    }
}