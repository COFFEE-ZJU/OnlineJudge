package cn.edu.zju.coffee.leetcode.no328;

import cn.edu.zju.coffee.leetcode.ListNode;

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode oddHead, oddTail, evenHead, evenTail;
        oddHead = oddTail = head;
        evenHead = evenTail = head.next;

        for (ListNode curTail = evenTail;
             curTail != null && curTail.next != null; ) {
            oddTail.next = curTail.next;
            oddTail = oddTail.next;
            evenTail.next = oddTail.next;
            evenTail = evenTail.next;
            curTail = evenTail;
        }

        oddTail.next = evenHead;
        return oddHead;
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
    }
}
