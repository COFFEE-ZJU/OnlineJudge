package leetcode._2ndtime.no230;

import leetcode.TreeNode;

/**
 * Whiteboard coding!
 */
public class Solution {
    private Integer sol;
    public int kthSmallest(TreeNode root, int k) {
        findAndCount(root, k);
        return sol;
    }

    private int findAndCount(TreeNode root, int k) {
        if (root == null) return 0;
        int kLeft = findAndCount(root.left, k);
        if (sol != null) return 0;
        if (kLeft == k-1) {
            sol = root.val;
            return 0;
        }

        int kRight = findAndCount(root.right, k-kLeft-1);
        return kLeft + kRight + 1;
    }
}