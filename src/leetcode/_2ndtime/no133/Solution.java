package leetcode._2ndtime.no133;

import java.util.*;

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    private Map<UndirectedGraphNode, UndirectedGraphNode> oldToNew = new HashMap<>();
    private Queue<UndirectedGraphNode> toDeal = new LinkedList<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        oldToNew.clear();
        toDeal.clear();
        genAndAdd(node);
        while(!toDeal.isEmpty()) {
            UndirectedGraphNode cur = toDeal.poll(), nn = genAndAdd(cur);
            for (UndirectedGraphNode oldNbr : cur.neighbors) {
                UndirectedGraphNode newNbr = genAndAdd(oldNbr);
                nn.neighbors.add(newNbr);
            }
        }
        return genAndAdd(node);
    }

    private UndirectedGraphNode genAndAdd(UndirectedGraphNode old) {
        UndirectedGraphNode nn = oldToNew.get(old);
        if (nn == null) {
            nn = new UndirectedGraphNode(old.label);
            oldToNew.put(old, nn);
            toDeal.add(old);
        }
        return nn;
    }

    private static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    }
}
