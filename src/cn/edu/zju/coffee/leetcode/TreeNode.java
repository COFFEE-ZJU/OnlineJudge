package cn.edu.zju.coffee.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Zhangkefei on 2016/1/22.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    @Override
    public String toString(){
        List<TreeNode> nodes = new LinkedList<>();
        TreeNode last = this;
        nodes.add(this);
        StringBuilder sb = new StringBuilder("{");
        while (!nodes.isEmpty()){
            TreeNode node = nodes.remove(0);
            if (node == null)
                sb.append("#,");
            else {
                sb.append(node.val).append(',');
                TreeNode tmp = node.left;
                if (tmp != null) last = tmp;
                nodes.add(tmp);

                tmp = node.right;
                if (tmp != null) last = tmp;
                nodes.add(tmp);

                if (last == node) break;
            }
        }

        sb.append('}');
        return sb.toString();
    }

    public static TreeNode genTree(Integer ... vals){
        if (vals == null || vals.length == 0 || vals[0] == null)
            return null;

        TreeNode root = new TreeNode(vals[0]);
        List<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        for (int i = 1; i < vals.length; ){
            Integer val;
            TreeNode node = nodes.remove(0);
            if ((val = vals[i++]) != null){
                node.left = new TreeNode(val);
                nodes.add(node.left);
            }
            if (i < vals.length && (val = vals[i++]) != null){
                node.right = new TreeNode(val);
                nodes.add(node.right);
            }
        }
        return root;
    }
}
