package leetcode._2ndtime.no113;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import leetcode.TreeNode;

/**
 * Whiteboard coding!
 *
 */
public class Solution {
    private static final List<List<Integer>> EMPTY = Collections.emptyList();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return EMPTY;
        int ss = sum - root.val;
        if (root.left == null && root.right == null) {
            if (ss == 0) {
                List<Integer> l = new LinkedList<>();
                l.add(root.val);
                List<List<Integer>> ll = new ArrayList<>();
                ll.add(l);
                return ll;
            } else {
                return EMPTY;
            }
        }
        List<List<Integer>> res;
        List<List<Integer>> left = pathSum(root.left, ss);
        List<List<Integer>> right = pathSum(root.right, ss);
        if (left == right) return EMPTY;
        if (left == EMPTY) res = right;
        else if (right == EMPTY) res = left;
        else {
            res = left;
            res.addAll(right);
        }
        for (List<Integer> l : res) {
            l.add(0, root.val);
        }
        return res;
    }
}
