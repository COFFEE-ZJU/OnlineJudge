package leetcode._1sttime.no102and107;

import leetcode.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> levelOrder(TreeNode root) {
        res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();
        nodes.add(root);
        levels.add(0);
        int prevLev = -1;
        List<Integer> curList = null;
        while (!nodes.isEmpty()) {
            int lev = levels.poll();
            TreeNode node = nodes.poll();
            if (lev != prevLev) {
                curList = new LinkedList<>();
                res.add(curList);
                prevLev = lev;
            }
            curList.add(node.val);
            if (node.left != null) {
                nodes.add(node.left);
                levels.add(lev+1);
            }
            if (node.right != null) {
                nodes.add(node.right);
                levels.add(lev+1);
            }
        }

        return res;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Collections.reverse(levelOrder(root));
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
    }
}