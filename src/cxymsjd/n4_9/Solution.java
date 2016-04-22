package cxymsjd.n4_9;

import cxymsjd.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Whiteboard coding!
 * From nowcoder.com
 * Created by zkf on 4/22/16.
 */
public class Solution {
    private ArrayList<ArrayList<Integer>> res;
    private int target;

    private void dfsFind(TreeNode node, int cur, LinkedList<Integer> list) {
        cur += node.val;
        list.add(node.val);
        if (node.left == null && node.right == null) {
            if (cur == target) res.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }

        if (node.left != null)
            dfsFind(node.left, cur, list);
        if (node.right != null)
            dfsFind(node.right, cur, list);

        list.remove(list.size()-1);
    }


    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        res = new ArrayList<>();
        this.target = target;
        if (root == null) return res;

        dfsFind(root, 0, new LinkedList<Integer>());

        return res;
    }
}
