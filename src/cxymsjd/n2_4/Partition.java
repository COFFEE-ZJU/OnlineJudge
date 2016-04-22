package cxymsjd.n2_4;

import cxymsjd.ListNode;

/**
 * Whiteboard coding!
 * From nowcoder.com
 * Created by zkf on 4/22/16.
 */
public class Partition {
    public ListNode partition(ListNode pHead, int x) {
        // write code here
        if (pHead == null) return null;

        ListNode dh1 = new ListNode(0), dh2 = new ListNode(0);
        ListNode tail1 = dh1, tail2 = dh2, cur = pHead;
        while (cur != null) {
            if (cur.val < x) {
                tail1.next = cur;
                tail1 = cur;
            }
            else {
                tail2.next = cur;
                tail2 = cur;
            }

            cur = cur.next;
        }

        tail1.next = dh2.next;
        tail2.next = null;

        return dh1.next;
    }
}
