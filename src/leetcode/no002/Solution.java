package leetcode.no002;

import leetcode.ListNode;

/**
 * Runtime Error, solved:
 * very strange you need to cut out the ListNode definition before submission
 * Last executed input:	[0], [0]
 * @author Zhangkefei
 *
 */

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode n1 = l1, n2 = l2, head = null, tail = null;
        int carry = 0;
        while(n1 != null && n2 != null){
        	int res = n1.val + n2.val + carry;
        	ListNode n = new ListNode(res % 10);
        	carry = res / 10;
        	if(tail == null)
        		head = tail = n;
        	else{
        		tail.next = n;
        		tail = n;
        	}
        	
        	n1 = n1.next;
        	n2 = n2.next;
        }
        
        while(n1 != null){
        	int res = n1.val + carry;
        	ListNode n = new ListNode(res % 10);
        	carry = res / 10;
        	tail.next = n;
    		tail = n;
    		
    		n1 = n1.next;
        }
        
        while(n2 != null){
        	int res = n2.val + carry;
        	ListNode n = new ListNode(res % 10);
        	carry = res / 10;
        	tail.next = n;
    		tail = n;
    		
    		n2 = n2.next;
        }
        
        if(carry == 1)
        	tail.next = new ListNode(carry);
        
        
        return head;
    }
    
    public static void main(String[] args) {
		ListNode node = new Solution().addTwoNumbers(ListNode.genNode(new int[]{0,2,2}), ListNode.genNode(new int[]{0,2,2,0}));
		System.out.println(node);
	}
}