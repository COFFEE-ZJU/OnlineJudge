package cn.edu.zju.coffee.leetcode.no101;

import cn.edu.zju.coffee.leetcode.TreeNode;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return isMirrorTree(root.left, root.right);
    }

    private boolean isMirrorTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        return (p.val == q.val && isMirrorTree(p.left, q.right) && isMirrorTree(p.right, q.left));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
    }
}