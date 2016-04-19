package leetcode._2ndtime.no024;

import leetcode.ListNode;

/**
 * Whiteboard coding!
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        int cnt = 0; boolean circ = false;
        for (ListNode n = head; n != null;) {
            cnt++;
            if (n.next == head) {
                circ = true;
                n.next = null;
            }
            n = n.next;
        }

        cnt /= 2;
        ListNode dh = new ListNode(0), tail = dh;
        dh.next = head;

        for (int i = 0; i < cnt; i++) {
            ListNode a = tail.next, b = a.next;
            a.next = b.next;
            b.next = a;
            tail.next = b;
            tail = a;
        }

        if (circ) {
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = dh.next;
        }

        return dh.next;
    }
}
