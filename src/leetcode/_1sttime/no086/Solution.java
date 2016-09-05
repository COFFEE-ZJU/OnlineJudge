package leetcode._1sttime.no086;

import leetcode.ListNode;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;

        ListNode frontHead, endHead, frontTail, endTail;
        frontHead = endHead = frontTail = endTail = null;
        for (ListNode cur = head; cur != null; cur = cur.next){
            if (cur.val < x){
                if (frontTail == null)
                    frontHead = frontTail = cur;
                else {
                    frontTail.next = cur;
                    frontTail = cur;
                }
            }
            else {
                if (endTail == null)
                    endHead = endTail = cur;
                else {
                    endTail.next = cur;
                    endTail = cur;
                }
            }
        }

        if (endHead == null || frontHead == null)
            return head;

        frontTail.next = endHead;
        endTail.next = null;

        return frontHead;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode ori = ListNode.genNode(new int[]{1,4,3,2,5,2});
        System.out.println(sol.partition(ori, 3));
    }
}