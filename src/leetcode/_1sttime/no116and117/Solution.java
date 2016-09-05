package leetcode._1sttime.no116and117;

import leetcode.TreeLinkNode;

public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;

        TreeLinkNode cur, prev, nextFisrt;
        cur = root;
        prev = null;
        nextFisrt = null;
        for (;cur != null;){
            TreeLinkNode l = cur.left, r = cur.right;

            if (l != null){
                if (nextFisrt == null)
                    nextFisrt = l;
                if (prev != null)
                    prev.next = l;
                prev = l;
            }

            if (r != null){
                if (nextFisrt == null)
                    nextFisrt = r;
                if (prev != null)
                    prev.next = r;
                prev = r;
            }

            if (cur.next == null){
                cur = nextFisrt;
                nextFisrt = null;
                prev = null;
            }
            else
                cur = cur.next;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeLinkNode node = TreeLinkNode.genTree(1,2,3,4,5,6,7);
        System.out.println(node);
        sol.connect(node);
        System.out.println(node);

        node = TreeLinkNode.genTree(1,null,-9,null,8,4,-3,null,null,-3,null,-6,null,null,-6,-4,-9,null,null,6);
        System.out.println(node);
        sol.connect(node);
        System.out.println(node);
    }
}