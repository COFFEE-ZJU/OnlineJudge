package leetcode.no112;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private int sum;

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        this.sum = sum;
        return traverse(root);
    }

    private boolean traverse(TreeNode node){
        if (node.left == null && node.right == null)
            return node.val == sum;

        if (node.left != null){
            node.left.val += node.val;
            if (traverse(node.left))
                return true;
        }

        if (node.right != null){
            node.right.val += node.val;
            if (traverse(node.right))
                return true;
        }

        return false;
    }

    private List<List<Integer>> retList;
    private List<Integer> array = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return Collections.emptyList();

        retList = new LinkedList<>();
        this.sum = sum;
        array.clear();
        array.add(root.val);
        traverse(root, 0);
        return retList;
    }

    private void traverse(TreeNode node, int idx) {
        if (node.left == null && node.right == null){
            if (sum == node.val)
                retList.add(new ArrayList<Integer>(array));

            return;
        }

        idx++;
        if (node.left != null) {
            array.add(node.left.val);
            node.left.val += node.val;
            traverse(node.left, idx);
            array.remove(array.size()-1);
        }

        if (node.right != null) {
            array.add(node.right.val);
            node.right.val += node.val;
            traverse(node.right, idx);
            array.remove(array.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode node = TreeNode.genTree(5,4,8,11,null,13,4,7,2,null,null,5,1);
        System.out.println(node);
        System.out.println(sol.pathSum(node, 22));
    }
}