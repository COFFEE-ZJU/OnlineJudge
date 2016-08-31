package leetcode._2ndtime.no257;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import leetcode.TreeNode;

/**
 * Whiteboard coding!
 */
public class Solution {
    List<String> res;
    StringBuilder sb = new StringBuilder();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return Collections.emptyList();

        res = new ArrayList<>();
        sb.setLength(0);
        genPaths(root);
        return res;
    }

    private void genPaths(TreeNode node) {
        if (node == null) return;
        int oriLen = sb.length();
        sb.append("->");
        sb.append(node.val);
        if (node.left == null && node.right == null) {
            res.add(sb.substring(2));
        } else {
            genPaths(node.left);
            genPaths(node.right);
        }

        sb.setLength(oriLen);
    }
}
