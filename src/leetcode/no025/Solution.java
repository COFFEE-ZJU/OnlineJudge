package leetcode.no025;

import leetcode.ListNode;

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
		System.out.println(node);
	}
}
