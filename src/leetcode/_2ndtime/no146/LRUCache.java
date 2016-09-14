package leetcode._2ndtime.no146;

import java.util.HashMap;
import java.util.Map;

/**
 * Whiteboard coding!
 */
public class LRUCache {
    private static class ListNode {
        final int key;
        int val;
        ListNode prev = null, succ = null;
        ListNode(int k, int v) {key = k; val = v;}
    }

    private Map<Integer, ListNode> map = new HashMap<>();
    private ListNode head, tail;
    private int cap, size;

    public LRUCache(int capacity) {
        cap = capacity <= 0 ? 16 : capacity;
        size = 0;
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.succ = tail;
        tail.prev = head;
    }

    public int get(int key) {
        ListNode node = map.get(key);
        if (node == null) return -1;

        removeNode(node);
        addToTail(node);

        return node.val;
    }

    public void set(int key, int value) {
        ListNode node = map.get(key);
        if (node == null) {
            node = new ListNode(key, value);

            if (size++ == cap) invalidateHead();
            map.put(key, node);
        } else {
            removeNode(node);
            node.val = value;
        }

        addToTail(node);
    }

    private void invalidateHead() {
        ListNode node = head.succ;
        removeNode(head.succ);
        map.remove(node.key);
        size--;
    }

    private void addToTail(ListNode node) {
        ListNode prev = tail.prev;
        prev.succ = node;
        tail.prev = node;

        node.prev = prev;
        node.succ = tail;
    }

    private void removeNode(ListNode node) {
        if (node == null) return;

        ListNode prev = node.prev, succ = node.succ;
        prev.succ = succ;
        succ.prev = prev;
        node.prev = null;
        node.succ = null;
    }
}