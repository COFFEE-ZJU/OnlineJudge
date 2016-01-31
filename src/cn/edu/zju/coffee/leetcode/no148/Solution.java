package cn.edu.zju.coffee.leetcode.no148;

import cn.edu.zju.coffee.leetcode.ListNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        List<ListNode> list = new LinkedList<>();
        for (ListNode node = head; node != null; ){
            ListNode next = node.next;
            node.next = null;
            list.add(node);
            node = next;
        }
        while (list.size() > 1) {
            int len = list.size() / 2;
            for (int i = 0; i < len; i++) {
                ListNode n1 = list.remove(0);
                ListNode n2 = list.remove(0);
                list.add(merge(n1, n2));
            }
        }

        return list.remove(0);
    }

    private ListNode merge(ListNode n1, ListNode n2){
        if (n1 == null)
            return n2;
        if (n2 == null)
            return n1;

        ListNode head = null, tail = null;
        for (; n1 != null && n2 != null; ){
            if (n1.val < n2.val){
                if (head == null)
                    head = tail = n1;
                else {
                    tail.next = n1;
                    tail = n1;
                }
                n1 = n1.next;
            }
            else {
                if (head == null)
                    head = tail = n2;
                else {
                    tail.next = n2;
                    tail = n2;
                }
                n2 = n2.next;
            }
        }

        if (n1 == null)
            tail.next = n2;
        else
            tail.next = n1;
        return head;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.sortList(ListNode.genNodes(3,2,1,4,6,2,34)));
    }
}
