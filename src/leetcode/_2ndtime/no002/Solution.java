package leetcode._2ndtime.no002;

import leetcode.ListNode;

/**
 * Whiteboard coding!
 */

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dh = new ListNode(0), tail = dh;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int cur1 = l1 == null ? 0 : l1.val;
            int cur2 = l2 == null ? 0 : l2.val;

            carry += cur1 + cur2;
            tail.next = new ListNode(carry % 10);
            carry /= 10;
            tail = tail.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry != 0) tail.next = new ListNode(carry);
        return dh.next;
    }
}