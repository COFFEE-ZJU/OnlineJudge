package leetcode._1sttime.no021;

import leetcode.ListNode;

public class Solution {
    private static final ListNode dummyHead = new ListNode(0);
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tail = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            }
            else {
                tail.next = l2;
                l2 = l2.next;
            }

            tail = tail.next;
        }

        if (l1 == null)
            tail.next = l2;
        if (l2 == null)
            tail.next = l1;

        return dummyHead.next;
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
    }
}
