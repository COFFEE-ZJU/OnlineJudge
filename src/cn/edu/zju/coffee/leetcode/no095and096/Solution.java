package cn.edu.zju.coffee.leetcode.no095and096;

import cn.edu.zju.coffee.leetcode.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0)
            return Collections.emptyList();
        return generateTrees(1, n+1);
    }

    private List<TreeNode> generateTrees(int from, int to) {
        if (from == to)
            return null;
        List<TreeNode> trees = new LinkedList<>();
        for (int i = from; i < to; i++) {
            List<TreeNode> lefts = generateTrees(from, i);
            List<TreeNode> rights = generateTrees(i+1, to);
            if (lefts == null && rights == null){
                trees.add(new TreeNode(i));
            }
            else if (lefts == null){
                for (TreeNode t : rights){
                    TreeNode node = new TreeNode(i);
                    node.right = t;
                    trees.add(node);
                }
            }
            else if (rights == null){
                for (TreeNode t : lefts){
                    TreeNode node = new TreeNode(i);
                    node.left = t;
                    trees.add(node);
                }
            }
            else {
                for (TreeNode ll : lefts){
                    for (TreeNode rr : rights){
                        TreeNode node = new TreeNode(i);
                        node.left = ll;
                        node.right = rr;
                        trees.add(node);
                    }
                }
            }
        }

        return trees;
    }

    public int numTrees(int n) {
        if (n < 0)
            return 0;

        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n ; i++) {
            for (int j = 0; j < i; j++)
                dp[i] += dp[j] * dp[i-j-1];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numTrees(1));
        System.out.println(sol.numTrees(2));
        System.out.println(sol.numTrees(3));

        System.out.println(sol.generateTrees(3));
    }
}