package leetcode.no103;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> retList = new LinkedList<>();
        if (root == null)
            return retList;

        List<TreeNode> curList = new LinkedList<>(), nextList = new LinkedList<>(), tmp;
        curList.add(root);
        boolean flip = false;
        while (!curList.isEmpty()){
            List<Integer> trav = new LinkedList<>();
            for (TreeNode node : curList){
                if (node.left != null)
                    nextList.add(node.left);
                if (node.right != null)
                    nextList.add(node.right);
                if (flip)
                    trav.add(0, node.val);
                else
                    trav.add(node.val);
            }
            flip = !flip;
            retList.add(trav);
            tmp = nextList;
            nextList = curList;
            curList = tmp;
            nextList.clear();
        }

        return retList;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.zigzagLevelOrder(TreeNode.genTree(3,9,20,null,1,15,7)));
    }
}