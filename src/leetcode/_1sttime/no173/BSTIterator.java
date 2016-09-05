package leetcode._1sttime.no173;

import leetcode.TreeNode;

import java.util.Stack;

/**
 * Created by Zhangkefei on 2016/1/30.
 */
public class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        for (TreeNode node = root; node != null; node = node.left)
            stack.push(node);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        if (!hasNext())
            throw new IllegalStateException();

        TreeNode node = stack.pop();
        for (TreeNode n = node.right; n != null; n = n.left)
            stack.push(n);

        return node.val;
    }

    public static void main(String[] args) {
        BSTIterator it = new BSTIterator(TreeNode.genTree(2,1,3));
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */