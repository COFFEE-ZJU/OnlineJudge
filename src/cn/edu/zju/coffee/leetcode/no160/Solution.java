package cn.edu.zju.coffee.leetcode.no160;

import cn.edu.zju.coffee.leetcode.ListNode;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == headB) return headA;
        if (headA == null || headB == null)
            return null;

        ListNode a1, a2, b1, b2;
        a1 = a2 = headA;
        b1 = b2 = headB;
        while (a1 != null && b1 != null) {
            a1 = a1.next;
            b1 = b1.next;
        }
        if (a1 == null) {
            while (b1 != null && b2 != null) {
                b2 = b2.next;
                b1 = b1.next;
            }
        }
        else {
            while (a1 != null && a2 != null) {
                a1 = a1.next;
                a2 = a2.next;
            }
        }

        while (a2 != b2) {
            a2 = a2.next;
            b2 = b2.next;
        }

        return a2;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
    }
}