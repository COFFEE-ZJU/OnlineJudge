package leetcode.no337;

import leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<TreeNode, Integer> prMax = new HashMap<>();
    private Map<TreeNode, Integer> pnrMax = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) return 0;
        pnrMax.clear();
        prMax.clear();
        return maxRob(root, false);
    }

    private int maxRob(TreeNode node, boolean parentRobbed) {
        if (node == null) return 0;

        if (parentRobbed) {
            Integer max = prMax.get(node);
            if (max == null) {
                max = maxRob(node.left, false) + maxRob(node.right, false);
                prMax.put(node, max);
            }
            return max;
        }
        else {
            Integer max = pnrMax.get(node);
            if (max == null) {
                max = Math.max(maxRob(node.left, false) + maxRob(node.right, false),
                        node.val + maxRob(node.left, true) + maxRob(node.right, true));
                pnrMax.put(node, max);
            }
            return max;
        }
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.rob(TreeNode.genTree(3,2,3,null,3,null,1)));
        System.out.println(sol.rob(TreeNode.genTree(3,4,5,1,3,null,1)));
    }
}
