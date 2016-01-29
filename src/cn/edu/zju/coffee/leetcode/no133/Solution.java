package cn.edu.zju.coffee.leetcode.no133;

import cn.edu.zju.coffee.leetcode.UndirectedGraphNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return node;

		Map<Integer, UndirectedGraphNode> map = new HashMap<>();
		List<UndirectedGraphNode> toDeal = new LinkedList<>(),
				next = new LinkedList<>();
		toDeal.add(node);
		UndirectedGraphNode retNode = new UndirectedGraphNode(node.label);
		map.put(node.label, retNode);
		while (!toDeal.isEmpty()){
			next.clear();
			for (UndirectedGraphNode n : toDeal){
				UndirectedGraphNode nn = map.get(n.label);
				for (UndirectedGraphNode adj : n.neighbors){
					UndirectedGraphNode nadj = map.get(adj.label);
					if (nadj == null){
						nadj = new UndirectedGraphNode(adj.label);
						next.add(adj);
						map.put(nadj.label, nadj);
					}
					nn.neighbors.add(nadj);
				}
			}
			List<UndirectedGraphNode> t = next;
			next = toDeal;
			toDeal = t;
		}

		return retNode;
	}
    
    public static void main(String[] args) {
		Solution sol = new Solution();
	}
}