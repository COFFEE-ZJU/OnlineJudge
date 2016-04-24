package jzoffer.n04;

import cxymsjd.TreeNode;

/**
 * Created by Zhangkefei on 2016/4/23.
 */
public class Solution {
    private int[] pre, in;
    private int pi,ii,len;
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        pi = ii = 0;
        this.pre = pre;
        this.in = in;
        len = pre.length;
        return build(null);
    }

    private TreeNode build(TreeNode next) {
        if (pi >= len || ii >= len) return null;
        if (next != null && in[ii] == next.val) {
            ii++;
            return null;
        }

        TreeNode node = new TreeNode(pre[pi++]);
        node.left = build(node);
        node.right = build(next);
        return node;
    }
}
