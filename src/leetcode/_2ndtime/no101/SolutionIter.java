package leetcode._2ndtime.no101;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Whiteboard coding!
 */
public class SolutionIter {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        List<TreeNode> left = new LinkedList<>(),
                right = new LinkedList<>();
        left.add(root.left);
        right.add(root.right);
        while (!left.isEmpty()) {
            TreeNode ln = left.remove(0),
                    rn = right.remove(0);
            if (ln == null && rn == null) continue;

            if (ln == null || rn == null || ln.val != rn.val) return false;

            left.add(ln.left);
            left.add(ln.right);
            right.add(rn.right);
            right.add(rn.left);
        }

        return true;
    }
}

