package leetcode._2ndtime.no332;

import java.util.*;

public class Solution {
    private Map<String, Node> map = new HashMap<>();
    public List<String> findItinerary(String[][] tickets) {
        map.clear();
        for (String[] tic : tickets) {
            Node from = getNodeByName(tic[0]),
                    to = getNodeByName(tic[1]);
            from.neighbors.add(to);
        }

        List<Node> path = getPath(getNodeByName("JFK"));
        List<String> namePath = new ArrayList<>(path.size());
        for (Node node : path)
            namePath.add(node.name);

        return namePath;
    }

    private List<Node> getPath(Node start) {
        List<Node> tail = null;
        List<Node> path = new LinkedList<>();
        path.add(start);
        while (!start.neighbors.isEmpty()) {
            Node next = start.neighbors.poll();
            List<Node> nPath = getPath(next);
            if (nPath.get(nPath.size()-1) != start)
                tail = nPath;
            else
                path.addAll(nPath);
        }
        if (tail != null)
            path.addAll(tail);

        return path;
    }

    private Node getNodeByName(String name) {
        Node node = map.get(name);
        if (node == null) {
            node = new Node(name);
            map.put(name, node);
        }
        return node;
    }

    private static class Node implements Comparable<Node>{
        final String name;
        final PriorityQueue<Node> neighbors;

        private Node(String name) {
            this.name = name;
            this.neighbors = new PriorityQueue<>();
        }

        @Override
        public int compareTo(Node o) {
            return name.compareTo(o.name);
        }
    }
}