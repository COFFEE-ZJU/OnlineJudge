package leetcode.no061;

import leetcode.ListNode;

public class Solution {
	public ListNode rotateRight(ListNode head, int k) {
		int len = 0;
		for (ListNode tmp = head; tmp != null; tmp = tmp.next)
			len ++;
		if (len <= 1)
			return head;
		k %= len;
		if (k == 0)
			return head;

		ListNode n1, n2;
		n1 = n2 = head;
		for (int i = 0; i < k; i++)
			n2 = n2.next;

		while (n2.next != null){
			n1 = n1.next;
			n2 = n2.next;
		}

		ListNode newHead = n1.next;
		n2.next = head;
		n1.next = null;
		return newHead;
	}

    public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.rotateRight(ListNode.genNode(new int[]{1,2,3,4,5}), 1));

	}
}