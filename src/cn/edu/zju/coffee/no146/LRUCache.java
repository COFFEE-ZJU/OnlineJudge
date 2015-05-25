package cn.edu.zju.coffee.no146;

import java.util.HashMap;
import java.util.Map;

class Node{
	int key;
	int val;
	Node prev;
	Node next;
	Node(int k, int v){
		key = k;
		val = v;
	}
}

public class LRUCache {
	private int capacity;
	private int size = 0;
	private Node head, tail;
	Map<Integer, Node> map = new HashMap<Integer, Node>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    private void flush(){
    	if(size > capacity){
    		size --;
    		int key = tail.key;
    		map.remove(key);
    		tail = tail.prev;
    		tail.next = null;
    	}
    }
    
    public int get(int key) {
    	Node node = map.get(key);
    	if(node == null) return -1;
    	set(node.key, node.val);
    	return node.val;
    }
    
    public void set(int key, int value) {
        Node node = map.get(key);
        if(node == null){
        	node = new Node(key, value);
        	map.put(key, node);
        	size ++;
        	
        	if(head == null || tail == null){
            	head = tail = node;
            	return;
        	}
        } else {
        	node.val = value;
        	if(node == head) return;
        	if(node == tail){
        		tail = node.prev;
        		tail.next = null;
        	} else {
        		Node p = node.prev, n = node.next;
        		p.next = n;
        		n.prev = p;
        	}
        }
        
        head.prev = node;
        node.prev = null;
        node.next = head;
        head = node;
        flush();
    }
    
    public static void main(String[] args) {
		LRUCache cache = new LRUCache(1);
		cache.set(2, 1);
		cache.get(2);
		cache.set(3, 2);
		cache.get(2);
		cache.get(3);
	}
}