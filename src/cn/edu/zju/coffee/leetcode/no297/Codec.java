package cn.edu.zju.coffee.leetcode.no297;

import cn.edu.zju.coffee.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";

        List<TreeNode> nodes = new LinkedList<>();
        TreeNode last = root;
        nodes.add(root);
        StringBuilder sb = new StringBuilder();
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

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0)
            return null;
        String[] nodeStrs = data.split(",");
        Integer rootVal = parse(nodeStrs[0]);
        if (rootVal == null) return null;
        TreeNode root = new TreeNode(rootVal);
        List<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        for (int i = 1; i < nodeStrs.length; ) {
            Integer val;
            TreeNode node = nodes.remove(0);
            if ((val = parse(nodeStrs[i++])) != null){
                node.left = new TreeNode(val);
                nodes.add(node.left);
            }
            if (i < nodeStrs.length && (val = parse(nodeStrs[i++])) != null){
                node.right = new TreeNode(val);
                nodes.add(node.right);
            }
        }

        return root;
    }

    private Integer parse(String nodeStr) {
        if (nodeStr.equals("#")) return null;
        return Integer.valueOf(nodeStr);
    }

    public static void main(String[] args) {
		Codec cc = new Codec();
        TreeNode node = TreeNode.genTree(1,2,3,null,null,4,5);
        String dec = cc.serialize(node);
        System.out.println(dec);
        System.out.println(cc.deserialize(dec));
    }
}
