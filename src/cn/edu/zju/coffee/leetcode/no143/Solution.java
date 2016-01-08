package cn.edu.zju.coffee.leetcode.no143;

import cn.edu.zju.coffee.leetcode.ListNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
    	List<ListNode> list = new LinkedList<ListNode>();
    	
    	for(ListNode node = head; node != null; node = node.next)
    		list.add(node);
    	
    	ListNode[] arr = list.toArray(new ListNode[0]);
    	int len = arr.length;
    	
    	for(int i = 0; i < (len - 1) / 2; i++){
    		arr[i].next = arr[len-1-i];
    		arr[len-1-i].next = arr[i+1];
    		arr[len-2-i].next = null;
    	}
    }
    
}