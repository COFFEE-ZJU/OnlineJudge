package cxymsjd.n4_4;

import cxymsjd.ListNode;
import cxymsjd.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Whiteboard coding!
 * From nowcoder.com
 * Created by zkf on 4/22/16.
 */
public class TreeLevel {
    public ListNode getTreeLevel(TreeNode root, int dep) {
        // write code here
        dep--;
        if (dep <= 0) return new ListNode(root.val);

        List<TreeNode> list = new LinkedList<>();
        List<TreeNode> next = new LinkedList<>();
        list.add(root);
        for (int i = 0; i < dep; i++) {
            for (TreeNode n : list) {
                if (n.left != null) next.add(n.left);
                if (n.right != null) next.add(n.right);
            }
            list.clear();
            List<TreeNode> tmp = list;
            list = next;
            next = tmp;
        }

        ListNode dh = new ListNode(0), tail = dh;
        for (TreeNode n : list) {
            tail.next = new ListNode(n.val);
            tail = tail.next;
        }

        return dh.next;
    }
}
