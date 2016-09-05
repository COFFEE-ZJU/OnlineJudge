package leetcode._1sttime.no019;

import leetcode.ListNode;

public class Solution {
    private static final ListNode dummyHead = new ListNode(0);
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) return head;

        dummyHead.next = head;
        ListNode fast = head, slow = dummyHead;
        for (int i = 0; i < n; i++) {
            if (fast == null) return head;
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return dummyHead.next;
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.removeNthFromEnd(ListNode.genNodes(1), 1));
        System.out.println(sol.removeNthFromEnd(ListNode.genNodes(1,2), 1));
        System.out.println(sol.removeNthFromEnd(ListNode.genNodes(1,2), 2));
        System.out.println(sol.removeNthFromEnd(ListNode.genNodes(1,2,3,4,5), 2));
    }
}
