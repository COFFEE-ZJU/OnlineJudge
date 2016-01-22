package cn.edu.zju.coffee.leetcode.no094;

import cn.edu.zju.coffee.leetcode.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return Collections.emptyList();

        List<Integer> ret = new LinkedList<>();
        List<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()){
            TreeNode node = list.get(0);
            if (node.left == null) {
                ret.add(node.val);
                list.remove(0);
                if (node.right != null)
                    list.add(0, node.right);
            }
            else {
                list.add(0, node.left);
                node.left = null;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(1), tmp = new TreeNode(2);
        tmp.left = new TreeNode(3);
        root.right = tmp;
        System.out.println(sol.inorderTraversal(root));

        System.out.println(sol.inorderTraversal(TreeNode.genTree(1, null, 2, 3)));
        System.out.println(sol.inorderTraversal(TreeNode.genTree(1,2,3,null,null,4,null,null,5)));
    }
}