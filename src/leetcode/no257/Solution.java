package leetcode.no257;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import leetcode.TreeNode;

/**
 * Whiteboard coding!
 *
 */
public class Solution {
    List<String> res;
    StringBuilder sb = new StringBuilder();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return Collections.emptyList();
        res = new ArrayList<>();
        sb.setLength(0);
        visit(root);
        return res;
    }

    private void visit(TreeNode node) {
        sb.append("->");
        sb.append(node.val);
        if (node.left == null && node.right == null) {
            res.add(sb.substring(2));
            return;
        }

        int len = sb.length();
        if (node.left != null) visit(node.left);
        sb.setLength(len);
        if (node.right != null) visit(node.right);
    }
}
