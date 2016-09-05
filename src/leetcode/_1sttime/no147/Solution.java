package leetcode._1sttime.no147;

import leetcode.ListNode;

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode sHead = head;
        ListNode uHead = head.next;
        sHead.next = null;
        while (uHead != null){
            ListNode uNext = uHead.next;
            if (uHead.val < sHead.val){
                uHead.next = sHead;
                sHead = uHead;
            }
            else {
                ListNode prev = sHead;
                for (ListNode cur = prev.next; cur != null; cur = cur.next){
                    if (cur.val >= uHead.val)
                        break;
                    prev = cur;
                }

                uHead.next = prev.next;
                prev.next = uHead;
            }

            uHead = uNext;
        }

        return sHead;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
    }
}
