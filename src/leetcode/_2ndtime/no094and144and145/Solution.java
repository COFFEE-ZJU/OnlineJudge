package leetcode._2ndtime.no094and144and145;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import leetcode.TreeNode;

/**
 * Whiteboard coding!
 */
public class Solution {
    private static class Trav {
        boolean childVisited = false;
        TreeNode node;
        Trav(TreeNode n) {node = n;}
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<Integer> res = new ArrayList<>();
        Stack<Trav> stack = new Stack<>();

        stack.push(new Trav(root));
        while (!stack.isEmpty()) {
            Trav t = stack.peek();
            if (!t.childVisited && t.node.left != null) {
                t.childVisited = true;
                stack.push(new Trav(t.node.left));
            } else {
                stack.pop();
                res.add(t.node.val);
                if (t.node.right != null) stack.push(new Trav(t.node.right));
            }
        }
        return res;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            res.add(t.val);

            if (t.right != null) stack.add(t.right);
            if (t.left != null) stack.add(t.left);
        }
        return res;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<Integer> res = new ArrayList<>();
        Stack<Trav> stack = new Stack<>();

        stack.push(new Trav(root));
        while (!stack.isEmpty()) {
            Trav t = stack.peek();
            if (!t.childVisited) {
                t.childVisited = true;

                if (t.node.right != null) stack.push(new Trav(t.node.right));
                if (t.node.left != null) stack.push(new Trav(t.node.left));
            } else {
                stack.pop();
                res.add(t.node.val);
            }
        }
        return res;
    }
}