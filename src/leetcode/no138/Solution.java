package leetcode.no138;

import leetcode.RandomListNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return null;

		Map<Integer, RandomListNode> map = new HashMap<>();
		RandomListNode retNode = new RandomListNode(head.label);
		map.put(retNode.label, retNode);
		for (RandomListNode node = head; node != null; node = node.next){
			RandomListNode nnode = map.get(node.label), next = node.next, rand = node.random;
			RandomListNode nn;
			if (next != null) {
				nn = map.get(next.label);
				if (nn == null) {
					nn = new RandomListNode(next.label);
					map.put(nn.label, nn);
				}
				nnode.next = nn;
			}
			if (rand != null) {
				nn = map.get(rand.label);
				if (nn == null) {
					nn = new RandomListNode(rand.label);
					map.put(nn.label, nn);
				}
				nnode.random = nn;
			}
		}

		return retNode;
	}
    public static void main(String[] args) {
		Solution sol = new Solution();
	}
}