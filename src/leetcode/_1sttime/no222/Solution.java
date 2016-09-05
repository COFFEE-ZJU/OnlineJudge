package leetcode._1sttime.no222;

import leetcode.TreeNode;

public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        return count(root, 0, 0);
    }

    private int count(TreeNode node, int lh, int rh) {
        if (lh <= 0) {
            lh = 0;
            for (TreeNode n = node; n != null; n = n.left)
                lh++;
        }

        if (rh <= 0) {
            rh = 0;
            for (TreeNode n = node; n != null; n = n.right)
                rh++;
        }

        if (lh == rh)
            return (1 << lh) - 1;
        if (lh == 2 && rh == 1)
            return 2;

        return count(node.left, lh-1, 0) + count(node.right, 0, rh-1) + 1;
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.countNodes(TreeNode.genTree(1)));
        System.out.println(sol.countNodes(TreeNode.genTree(1,2)));
        System.out.println(sol.countNodes(TreeNode.genTree(1,2,3)));
        System.out.println(sol.countNodes(TreeNode.genTree(1,2,3,4,5,6)));
        System.out.println(sol.countNodes(TreeNode.genTree(1,2,3,4,5,6,7)));
    }
}
