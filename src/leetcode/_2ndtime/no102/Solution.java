package leetcode._2ndtime.no102;

/**
 * Whiteboard coding!
 */

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<List<Integer>> res = new LinkedList<>();
        List<TreeNode> prevList = new LinkedList<>(),
                curList = new LinkedList<>();
        prevList.add(root);
        while (!prevList.isEmpty()){
            curList.clear();
            res.add(transform(prevList));
            for (TreeNode node : prevList) {
                if (node.left != null)
                    curList.add(node.left);
                if (node.right != null)
                    curList.add(node.right);
            }
            List<TreeNode> tmp = curList;
            curList = prevList;
            prevList = tmp;
        }

        return res;
    }

    private List<Integer> transform(List<TreeNode> list) {
        List<Integer> res = new ArrayList<>(list.size());
        for (TreeNode node : list)
            res.add(node.val);
        return res;
    }
}