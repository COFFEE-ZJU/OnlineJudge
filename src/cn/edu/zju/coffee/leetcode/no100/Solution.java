package cn.edu.zju.coffee.leetcode.no100;

import cn.edu.zju.coffee.leetcode.TreeNode;

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q) return true;
        if (p == null || q == null) return false;

        return (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
    }
}