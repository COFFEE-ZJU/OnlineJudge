package cn.edu.zju.coffee.leetcode.no025;

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

	@Override
	public String toString() {
		return "Node(" + val +") -> " + next;
	}

	public void print(){
		System.out.print(this);
	}
}

public class Solution {

	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k <= 0)
			return head;

		ListNode node = head, prev = null;
		ListNode newHead, newTail, prevTail = null, retHead = head;
		while (true) {
			newTail = node;
			int cnt = 0;
			while (node != null && cnt < k) {
				prev = node;
				node = node.next;
				cnt++;
			}
			if(cnt == k) {
				prev.next = null;
				newHead = reverse(newTail);
				if (prevTail == null)
					retHead = newHead;
				else
					prevTail.next = newHead;

				prevTail = newTail;
			}
			else
				break;
		}
		if (prevTail != null)
			prevTail.next = newTail;

		return retHead;
	}

	private ListNode reverse(ListNode head){
		if (head == null || head.next == null)
			return head;

		ListNode node = head, prev = null, tmp;
		while(node != null){
			tmp = node.next;
			node.next = prev;
			prev = node;
			node = tmp;
		}

		return prev;
	}
    
    public static void main(String[] args) {
		ListNode node = new Solution().reverseKGroup(ListNode.genNode(new int[]{1}), 2);
		node.print();
	}
}
