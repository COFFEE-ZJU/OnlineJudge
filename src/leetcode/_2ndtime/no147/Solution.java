package leetcode._2ndtime.no147;

import leetcode.ListNode;

/**
 * Whiteboard coding!
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode res = new ListNode(head.val);

        for (ListNode cur = head.next; cur != null; cur = cur.next) {
            ListNode nn = new ListNode(cur.val), prev = null;
            for (ListNode node = res; node != null && node.val < nn.val; node = node.next) {
                prev = node;
            }
            if (prev == null) {
                nn.next = res;
                res = nn;
            } else {
                nn.next = prev.next;
                prev.next = nn;
            }
        }

        return res;
    }
}