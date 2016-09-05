package leetcode._1sttime.no023;

import leetcode.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

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
		System.out.println(head);
	}
}