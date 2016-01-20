package cn.edu.zju.coffee.leetcode.no082;

import cn.edu.zju.coffee.leetcode.ListNode;

/**
 * Created by zkf on 12/31/15.
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode retNode = null, tail = null;
        for (ListNode prev = null, cur = head, next = cur.next; cur != null; ){
            if ((prev == null || prev.val != cur.val) &&
                    (next == null || next.val != cur.val)) {
                if (retNode == null){
                    retNode = new ListNode(cur.val);
                    tail = retNode;
                }
                else {
                    tail.next = new ListNode(cur.val);
                    tail = tail.next;
                }
            }

            if (next == null)
                break;

            prev = cur;
            cur = next;
            next = next.next;
        }

        return retNode;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode node = ListNode.genNode(new int[]{0,1,1,2,3,3,4});
        ListNode ret = sol.deleteDuplicates(node);
        System.out.println(ret);
    }
}