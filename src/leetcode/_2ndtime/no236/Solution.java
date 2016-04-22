package leetcode._2ndtime.no236;

import leetcode.TreeNode;

import java.util.Stack;

public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> st1 = new Stack<>(), st2 = new Stack<>();
        getPath(root, p, q, st1, st2);
        TreeNode res = root;

        if (st1.isEmpty() && st2.isEmpty())
            return null;

        while(!st1.isEmpty() && !st2.isEmpty() && st1.peek() == st2.peek()) {
            res = st1.pop();
            st2.pop();
        }

        return res;
    }

    private int getPath(TreeNode root, TreeNode p, TreeNode q,
                        Stack<TreeNode> st1, Stack<TreeNode> st2) {
        if (root == null) return 0;

        int res = 0;
        if (root == p) {
            st1.push(root);
            res++;
        }
        if (root == q) {
            st2.push(root);
            res+=2;
        }

        int tmpRes =  getPath(root.left, p, q, st1, st2);
        if (tmpRes == 1)
            st1.push(root);
        else if (tmpRes == 2)
            st2.push(root);

        res += tmpRes;
        if (res == 3) return res;

        tmpRes = getPath(root.right, p, q, st1, st2);
        if (tmpRes == 1)
            st1.push(root);
        else if (tmpRes == 2)
            st2.push(root);

        res += tmpRes;
        return res;
    }


    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     Stack<TreeNode> st1 = new Stack<>(), st2 = new Stack<>();
    //     getPath(root, p, st1);
    //     getPath(root, q, st2);
    //     TreeNode res = root;

    //     if (st1.isEmpty() && st2.isEmpty())
    //         return null;

    //     while(!st1.isEmpty() && !st2.isEmpty() && st1.peek() == st2.peek()) {
    //         res = st1.pop();
    //         st2.pop();
    //     }

    //     return res;
    // }

    // private boolean getPath(TreeNode root, TreeNode n, Stack<TreeNode> st) {
    //     if (root == null) return false;
    //     if (root == n) {
    //         st.push(root);
    //         return true;
    //     }

    //     if (getPath(root.left, n, st)) {
    //         st.push(root);
    //         return true;
    //     }

    //     if (getPath(root.right, n, st)) {
    //         st.push(root);
    //         return true;
    //     }

    //     return false;
    // }
}
