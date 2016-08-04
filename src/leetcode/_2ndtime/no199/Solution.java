package leetcode._2ndtime.no199;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Whiteboard coding!
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<Integer> res = new ArrayList<>();
        List<TreeNode> level = new ArrayList<>();
        List<TreeNode> level2 = new ArrayList<>();
        level.add(root);
        while (!level.isEmpty()) {
            level2.clear();
            res.add(level.get(0).val);
            for (TreeNode node : level) {
                if (node.right != null)
                    level2.add(node.right);
                if (node.left != null)
                    level2.add(node.left);
            }
            List<TreeNode> tmp = level;
            level = level2;
            level2 = tmp;
        }

        return res;
    }
}
