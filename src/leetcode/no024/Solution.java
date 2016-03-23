package leetcode.no024;

import leetcode.ListNode;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode dumHead = new ListNode(0);
        dumHead.next = head;
        
        ListNode n1 = dumHead,n2,n3,n4;
        while((n2=n1.next) != null && (n3=n2.next) != null){
        	n4 = n3.next;
        	n1.next = n3;
        	n3.next = n2;
        	n2.next = n4;
        	
        	n1 = n2;
        }
        
        return dumHead.next;
    }
    
    public static void main(String[] args) {
		ListNode node = new Solution().swapPairs(ListNode.genNode(new int[]{1,2,3,4,5}));
		System.out.println(node);
	}
}