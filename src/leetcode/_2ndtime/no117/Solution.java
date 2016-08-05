package leetcode._2ndtime.no117;

import leetcode.TreeLinkNode;

/**
 * Whiteboard coding!
 *
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;

        TreeLinkNode nextPrev = null, nextStart = null;
        for(;root != null; root = root.next) {
            if (root.left != null) {
                if (nextStart == null) {
                    nextStart = nextPrev = root.left;
                } else {
                    nextPrev.next = root.left;
                    nextPrev = nextPrev.next;
                }
            }

            if (root.right != null) {
                if (nextStart == null) {
                    nextStart = nextPrev = root.right;
                } else {
                    nextPrev.next = root.right;
                    nextPrev = nextPrev.next;
                }
            }
        }
        connect(nextStart);
    }
}
