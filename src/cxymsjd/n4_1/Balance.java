package cxymsjd.n4_1;

import cxymsjd.TreeNode;

/**
 * Whiteboard coding!
 * From nowcoder.com
 * Created by zkf on 4/22/16.
 */
public class Balance {
    private int checkBalance(TreeNode node) {
        if (node == null) return 0;
        int left = checkBalance(node.left);
        int right = checkBalance(node.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1)
            return -1;
        else
            return Math.max(left, right) + 1;
    }

    public boolean isBalance(TreeNode root) {
        // write code here
        return checkBalance(root) != -1;
    }

}
