package leetcode._2ndtime.no095;

import leetcode.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Whiteboard coding!
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) return Collections.emptyList();
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int st, int end) {
        if (st > end)
            return Collections.singletonList(null);
        if (st == end)
            return Collections.singletonList(new TreeNode(st));

        List<TreeNode> res = new LinkedList<>();
        for (int i = st; i <= end; i++) {
            List<TreeNode> leftList = generateTrees(st, i-1);
            List<TreeNode> rightList = generateTrees(i+1, end);
            for (TreeNode ln : leftList) {
                for (TreeNode rn : rightList) {
                    TreeNode node = new TreeNode(i);
                    node.left = ln;
                    node.right = rn;
                    res.add(node);
                }
            }
        }

        return res;
    }
}