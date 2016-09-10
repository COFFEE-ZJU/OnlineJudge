package leetcode._2ndtime.no103;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import leetcode.TreeNode;

/**
 * Whiteboard coding!
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<TreeNode> prev = new ArrayList<>();
        List<TreeNode> cur = new ArrayList<>();
        prev.add(root);

        List<List<Integer>> res = new ArrayList<>();
        boolean flip = false;

        while (!prev.isEmpty()) {
            cur.clear();
            List<Integer> l = new LinkedList<>();

            for (TreeNode node : prev) {
                if (flip) l.add(0, node.val);
                else l.add(node.val);

                if (node.left != null) cur.add(node.left);
                if (node.right != null) cur.add(node.right);
            }
            res.add(l);

            List<TreeNode> tmp = prev;
            prev = cur;
            cur = tmp;
            flip = !flip;
        }

        return res;
    }
}