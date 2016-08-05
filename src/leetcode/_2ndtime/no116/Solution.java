package leetcode._2ndtime.no116;

import leetcode.TreeLinkNode;

/**
 * Whiteboard coding!
 *
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        connect(null, root);
    }

    private void connect(TreeLinkNode left, TreeLinkNode cur) {
        if (cur == null) return;
        if (left != null) {
            left.next = cur;
            connect(left.right, cur.left);
        } else {
            connect(null, cur.left);
        }

        connect(cur.left, cur.right);
    }
}
