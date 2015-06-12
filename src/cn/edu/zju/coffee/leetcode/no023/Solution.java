package cn.edu.zju.coffee.leetcode.no023;

import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
	
	static ListNode genNode(int[] xs){
		if(xs.length == 0) return null;
		ListNode head = new ListNode(xs[0]), tail = head;
		for(int i = 1; i < xs.length; i++){
			ListNode node = new ListNode(xs[i]);
			tail.next = node;
			tail = node;
		}
		return head;
	}
	
	public void print(){
		System.out.print(val);
		if(next != null){
			System.out.print(" -> ");
			next.print();
		}
	}
}

public class Solution {
	private Comparator<ListNode> comp = new Comparator<ListNode>() {
		@Override
		public int compare(ListNode o1, ListNode o2) {
			return o1.val - o2.val;
		}
	};
	private PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(comp);
	
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        
    	for(ListNode node: lists)
        	if(node != null) queue.add(node);
        
    	ListNode head = new ListNode(0), tail = head;
    	
    	while(!queue.isEmpty()){
    		tail.next = queue.poll();
    		tail = tail.next;
    		if(tail.next != null)
        		queue.add(tail.next);
    	}
        
    	return head.next;
    }
    
    public static void main(String[] args) {
    	ListNode[] lists = new ListNode[]{
    			null
//    			ListNode.genNode(new int[]{1,3,3}),
//    			ListNode.genNode(new int[]{4,6,8}),
//    			ListNode.genNode(new int[]{5,8,10}),
//    			ListNode.genNode(new int[]{2,10,19}),
    			};
    	
    	ListNode head = new Solution().mergeKLists(lists);
    	head.print();
	}
}