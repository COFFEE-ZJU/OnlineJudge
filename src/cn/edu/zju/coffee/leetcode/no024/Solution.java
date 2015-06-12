package cn.edu.zju.coffee.leetcode.no024;

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
		node.print();
	}
}