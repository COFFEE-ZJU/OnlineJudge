package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Zhangkefei on 2016/1/22.
 */
public class TreeLinkNode {
    public int val;
    public TreeLinkNode left;
    public TreeLinkNode right;
    public TreeLinkNode next;
    public TreeLinkNode(int x) { val = x; }

    @Override
    public String toString(){
        List<TreeLinkNode> nodes = new LinkedList<>();
        nodes.add(this);
        StringBuilder sb = new StringBuilder("{");
        while (!nodes.isEmpty()){
            TreeLinkNode node = nodes.remove(0);
            if (node == null)
                sb.append("#,");
            else {
                sb.append(node.val+"("+(node.next == null ? "#" : node.next.val)+"),");
                nodes.add(node.left);
                nodes.add(node.right);
            }

        }

        sb.append('}');
        return sb.toString();
    }

    public static TreeLinkNode genTree(Integer ... vals){
        if (vals == null || vals.length == 0 || vals[0] == null)
            return null;

        TreeLinkNode root = new TreeLinkNode(vals[0]);
        List<TreeLinkNode> nodes = new LinkedList<>();
        nodes.add(root);

        for (int i = 1; i < vals.length; ){
            Integer val;
            TreeLinkNode node = nodes.remove(0);
            if ((val = vals[i++]) != null){
                node.left = new TreeLinkNode(val);
                nodes.add(node.left);
            }
            if (i < vals.length && (val = vals[i++]) != null){
                node.right = new TreeLinkNode(val);
                nodes.add(node.right);
            }
        }
        return root;
    }
}
