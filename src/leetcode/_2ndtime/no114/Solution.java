package leetcode._2ndtime.no114;

import java.util.ArrayList;
import java.util.List;

import leetcode.TreeNode;

/**
 * Whiteboard coding!
 *
 */
public class Solution {
    private List<TreeNode> list = new ArrayList<>();
    public void flatten(TreeNode root) {
        list.clear();
        visit(root);
        TreeNode prev = null;
        for (TreeNode node : list) {
            if (prev != null) {
                prev.right = node;
            }
            node.left = null;
            node.right = null;
            prev = node;
        }
    }

    private void visit(TreeNode node) {
        if (node == null) return;
        list.add(node);
        visit(node.left);
        visit(node.right);
    }
}
