package leetcode._2ndtime.no222;

import leetcode.TreeNode;

/**
 * Whiteboard coding!
 */
public class Solution {
    public int countNodes(TreeNode root) {
        return countNodes(root, -1, -1);
    }

    public int countNodes(TreeNode root, int left, int right) {
        if (root == null) return 0;
        if (left == -1)
            left = leftPathCount(root);
        if (right == -1)
            right = rightPathCount(root);

        if (left == right) return (1 << left) - 1;
        else return countNodes(root.left, left-1, -1) + countNodes(root.right, -1, right-1) + 1;
    }

    public int leftPathCount(TreeNode root) {
        int count = 0;
        while(root != null) {
            count++;
            root = root.left;
        }
        return count;
    }

    public int rightPathCount(TreeNode root) {
        int count = 0;
        while(root != null) {
            count++;
            root = root.right;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countNodes(TreeNode.genTree(1,2,3,4,5,6)));
    }
}