package leetcode._1sttime.no207;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    int nums;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return true;
        nums = numCourses;
        Node[] nodes = new Node[nums];
        for (int i = 0; i < nums; i++) {
            nodes[i] = new Node();
        }

        for (int[] req : prerequisites){
            Node pred = nodes[req[1]], succ = nodes[req[0]];
            if (pred == succ) return false;
            pred.adjs.add(succ);
            succ.indegree++;
        }

        List<Node> list = new LinkedList<>();
        for (Node node : nodes){
            if (node.indegree == 0) list.add(node);
        }
        int cnt = 0;
        while (!list.isEmpty()){
            Node node = list.remove(0);
            cnt++;
            for (Node adj : node.adjs){
                adj.indegree--;
                if (adj.indegree == 0) list.add(adj);
            }
        }

        return cnt == nums;
    }

    private static class Node {
        int indegree = 0;
        List<Node> adjs = new LinkedList<>();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.canFinish(2, new int[][]{new int[]{1,0}}));
        System.out.println(sol.canFinish(2, new int[][]{new int[]{1,0}, new int[]{0,1}}));
    }
}
