package toutiao.screen.n5;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU Cache 设计一个数据结构，支持 Get、Set 方法，给出具体代码实现，语言不限。LRU是Least Recently Used 近期最少使用算法。
 * size = 10
 * O(1)
 */
public class Cache {
    private static class Node {
        Node prev, succ;
        int val, key;
    }
    private int cap, size;
    private Map<Integer, Node> map;
    private Node head,tail;

    private static int DEFAULT_CAP = 10;
    public Cache(int cap) {
        if (cap <= 0) cap = DEFAULT_CAP;
        this.cap = cap;
        head = new Node();
        tail = new Node();
        size = 0;
        head.succ = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    public void set(int k, int v) {
        Node node = getNode(k);
        if (node != null) {
            node.val = v;
            return;
        }

        node = new Node();
        node.key = k;
        node.val = v;
        addToHead(node);
        map.put(k, node);

        if (size == cap) {
            removeTail();
        } else {
            size++;
        }
    }

    private void removeTail() {
        Node n = tail.prev;
        Node pprev = n.prev;
        pprev.succ = tail;
        tail.prev = pprev;
        n.prev = null;
        n.succ = null;
        map.remove(n.key);
    }

    private Node getNode(int k) {
        Node node = map.get(k);
        if (node == null) return null;

        node.prev.succ = node.succ;
        node.succ.prev = node.prev;

        addToHead(node);
        return node;
    }

    private void addToHead(Node node) {
        node.succ = head.succ;
        head.succ = node;
        node.succ.prev = node;
        node.prev = head;
    }

    public Integer get(int k) {
        Node node = getNode(k);
        return node == null ? null : node.val;
    }
}