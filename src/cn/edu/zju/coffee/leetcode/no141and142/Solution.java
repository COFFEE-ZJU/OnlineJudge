package cn.edu.zju.coffee.leetcode.no141and142;

import cn.edu.zju.coffee.leetcode.ListNode;

public class Solution {
	public boolean hasCycle(ListNode head) {
		return cycleLen(head) > 0;
	}

	public ListNode detectCycle(ListNode head) {
		int len = cycleLen(head);
		if (len == 0)
			return null;

		ListNode n1 = head, n2 = head;
		for (int i = 0; i < len; i++)
			n2 = n2.next;

		while (n1 != n2){
			n1 = n1.next;
			n2 = n2.next;
		}

		return n1;
	}

	private int cycleLen(ListNode head){
		int len = 1;
		try {
			ListNode n1 = head, n2 = n1.next;
			while (n1 != n2){
				n1 = n1.next;
				n2 = n2.next.next;
				len++;
			}
			return len;
		} catch (NullPointerException npe){
			return 0;
		}
	}

    public static void main(String[] args) {
		Solution sol = new Solution();
	}
}