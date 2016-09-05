package leetcode._1sttime.no083;

import leetcode.ListNode;

/**
 * Created by zkf on 12/31/15.
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode retNode = new ListNode(head.val);
        ListNode tail = retNode;
        for (ListNode prev = head, cur = head.next; cur != null; cur = cur.next){
            if (cur.val != prev.val) {
                tail.next = new ListNode(cur.val);
                tail = tail.next;
                prev = cur;
            }
        }

        return retNode;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode node = ListNode.genNode(new int[]{1,1,2,3,3});
        ListNode ret = sol.deleteDuplicates(node);
        System.out.println(ret);
    }
}