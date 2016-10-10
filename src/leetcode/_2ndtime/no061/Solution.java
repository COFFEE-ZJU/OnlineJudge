package leetcode._2ndtime.no061;

import leetcode.ListNode;

/**
 * Whiteboard coding!
 */

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) return head;

        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        k = len - (k % len);
        if (k == len) return head;

        tail.next = head;
        for (int i = 0; i < k; i++) {
            tail = tail.next;
        }

        ListNode nh = tail.next;
        tail.next = null;
        return nh;
    }
}