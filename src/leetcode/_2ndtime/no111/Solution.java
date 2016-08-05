package leetcode._2ndtime.no111;

import java.util.ArrayList;
import java.util.List;

import leetcode.TreeNode;

/**
 * Whiteboard coding!
 *
 */
public class Solution {
    private int len;
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        len = 0;
        List<TreeNode> list = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()) {
            len++;
            list2.clear();
            for (TreeNode node : list) {
                if (node.left == null && node.right == null)
                    return len;
                if (node.left != null) list2.add(node.left);
                if (node.right != null) list2.add(node.right);
            }
            List<TreeNode> tmp = list;
            list = list2;
            list2 = tmp;
        }
        return len;
    }
}
