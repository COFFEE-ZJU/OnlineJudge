package cn.edu.zju.coffee.leetcode.no312;

import java.util.*;

public class Solution {
    private static class Node {
        final int label;
        List<Node> adjs;

        private Node(int label) {
            this.label = label;
            adjs = new ArrayList<>();
        }

        private void addAdj(Node node) {
            adjs.add(node);
        }
    }

    private Node[] nodes;
    private Queue<Integer> queue = new LinkedList<>();
    private int[] prev, length;
    private int maxLabel, max;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }

        for (int[] e : edges) {
            nodes[e[0]].addAdj(nodes[e[1]]);
            nodes[e[1]].addAdj(nodes[e[0]]);
        }

        prev = new int[n];
        length = new int[n];
        Arrays.fill(prev, -1);
        prev[0] = 0;
        queue.add(0);
        maxLabel = 0;
        max = 0;
        findMax();

        Arrays.fill(prev, -1);
        Arrays.fill(length, 0);
        prev[maxLabel] = maxLabel;
        queue.add(maxLabel);
        max = 0;
        findMax();

        int mid = maxLabel;
        for (int i = 0; i < max/2; i++) {
            mid = prev[mid];
        }
        if (max % 2 == 0) return Collections.singletonList(mid);
        else return Arrays.asList(mid, prev[mid]);
    }

    private void findMax() {
        while (!queue.isEmpty()) {
            Node cur = nodes[queue.poll()];
            for (Node adj : cur.adjs) {
                int l = adj.label;
                if (prev[l] != -1) continue;
                prev[l] = cur.label;
                length[l] = length[cur.label] + 1;
                if (length[l] > max) {
                    max = length[l];
                    maxLabel = l;
                }
                queue.add(l);
            }
        }
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.findMinHeightTrees(4, new int[][]{
                new int[]{1,0},
                new int[]{1,2},
                new int[]{1,3},
        }));

        System.out.println(sol.findMinHeightTrees(6, new int[][]{
                new int[]{3,0},
                new int[]{3,1},
                new int[]{3,2},
                new int[]{3,4},
                new int[]{5,4},
        }));
    }
}
