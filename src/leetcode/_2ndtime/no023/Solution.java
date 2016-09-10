package leetcode._2ndtime.no023;

import java.util.Comparator;
import java.util.PriorityQueue;

import leetcode.ListNode;

/**
 * Whiteboard coding!
 */
public class Solution {
    private static final Comparator<ListNode> comp = new Comparator<ListNode>() {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return Integer.compare(o1.val, o2.val);
        }
    };

    private PriorityQueue<ListNode> heap = new PriorityQueue<>(11, comp);
    public ListNode mergeKLists(ListNode[] lists) {
        heap.clear();
        for (ListNode node : lists) {
            if (node != null) heap.add(node);
        }
        ListNode head, tail;
        head = tail = null;
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            if (head == null) {
                head = tail = new ListNode(node.val);
            } else {
                tail.next = new ListNode(node.val);
                tail = tail.next;
            }

            if (node.next != null) heap.add(node.next);
        }
        return head;
    }
}