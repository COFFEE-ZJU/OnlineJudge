package leetcode._2ndtime.no310;

import java.util.*;

public class Solution {
    private Node[] nodes;
    private int[] prevs;
    private List<Node> nList = new LinkedList<>(), nList2 = new LinkedList<>();

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        nodes = new Node[n];
        prevs = new int[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            nodes[a].neighbors.add(nodes[b]);
            nodes[b].neighbors.add(nodes[a]);
        }

        List<Node> path = getLongestPath(nodes[0]);
        path = getLongestPath(path.get(0));
        int size = path.size();
        if (size % 2 == 0) {
            return Arrays.asList(path.get(size / 2 - 1).label, path.get(size / 2).label);
        }
        else {
            return Collections.singletonList(path.get(size / 2).label);
        }
    }

    private List<Node> getLongestPath(Node start) {
        nList.clear();
        Arrays.fill(prevs, -1);
        int idx = start.label;
        prevs[idx] = idx;
        nList.add(start);

        int maxIdx = -1;
        while (!nList.isEmpty()) {
            nList2.clear();
            for (Node node : nList) {
                for (Node nbr : node.neighbors) {
                    int i = nbr.label;
                    if (prevs[i] == -1) {
                        maxIdx = i;
                        prevs[i] = node.label;
                        nList2.add(nbr);
                    }
                }
            }
            List<Node> tmp = nList;
            nList = nList2;
            nList2 = tmp;
        }

        List<Node> path = new ArrayList<>();
        idx = maxIdx;
        while (idx != prevs[idx]) {
            path.add(nodes[idx]);
            idx = prevs[idx];
        }
        path.add(nodes[idx]);
        return path;
    }
    
    private static class Node {
        int label;
        List<Node> neighbors;
        Node(int x) { label = x; neighbors = new ArrayList<Node>(); }
    }
}
