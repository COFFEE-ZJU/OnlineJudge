package cn.edu.zju.coffee.leetcode.no310;

import java.util.PriorityQueue;

public class Solution {
    private static class Node implements Comparable<Node>{
        Node left, right;
        final int val;

        private Node(int val) {
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(val, o.val);
        }
    }


    public int maxCoins(int[] nums) {
        int len;
        if (nums == null || (len=nums.length) == 0) return 0;
        if (len == 1) return nums[0];
        Node[] nodes = new Node[len];
        for (int i = 0; i < len; i++)
            nodes[i] = new Node(nums[i]);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 1; i < len - 1; i++) {
            nodes[i].left = nodes[i-1];
            nodes[i].right = nodes[i+1];

            pq.add(nodes[i]);
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            sum += node.val * node.left.val * node.right.val;
            node.left.right = node.right;
            node.right.left = node.left;
        }

        sum += nums[0] * nums[len-1];
        sum += Math.max(nums[0], nums[len-1]);
        return sum;
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.maxCoins(new int[]{3, 1, 5, 8}));
    }
}
