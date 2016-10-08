package leetcode._2ndtime.no086;

import leetcode.ListNode;

/**
 * Whiteboard coding!
 */

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dbh = new ListNode(0), dbt = dbh;
        ListNode dh = new ListNode(0);
        dh.next = head;
        ListNode prev = dh, cur = head;
        while (cur != null) {
            if (cur.val >= x) {
                prev.next = cur.next;
                cur.next = null;
                dbt.next = cur;
                dbt = cur;

                cur = prev.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        prev.next = dbh.next;
        return dh.next;
    }

    public static void main(String[] args) {
        new Solution().partition(ListNode.genNodes(1), 2);
    }
}