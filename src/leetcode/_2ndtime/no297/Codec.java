package leetcode._2ndtime.no297;

import java.util.ArrayList;
import java.util.List;

import leetcode.TreeNode;

/**
 * Whiteboard coding!
 */
public class Codec {
    private List<TreeNode> nodes = new ArrayList<>();
    private TreeNode lastOccor;
    private StringBuilder sb = new StringBuilder();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        nodes.clear();
        lastOccor = root;
        nodes.add(root);
        sb.setLength(0);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.remove(0);
            if (node == null) {
                sb.append("#,");
            } else {
                sb.append(node.val);
                sb.append(',');
                TreeNode n = node.left;
                nodes.add(n);
                if (n != null) lastOccor = n;
                n = node.right;
                nodes.add(n);
                if (n != null) lastOccor = n;
            }
            if (node == lastOccor) break;
        }
        return sb.substring(0, sb.length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;

        String[] ns = data.split(",");
        nodes.clear();
        TreeNode root = parseNode(ns[0]);
        nodes.add(root);

        for (int i = 1; i < ns.length;) {
            TreeNode node = nodes.remove(0);
            TreeNode c = parseNode(ns[i++]);
            if (c != null) {
                node.left = c;
                nodes.add(c);
            }
            if (i >= ns.length) break;
            c = parseNode(ns[i++]);
            if (c != null) {
                node.right = c;
                nodes.add(c);
            }
        }

        return root;
    }

    private TreeNode parseNode(String n) {
        if ("#".equals(n)) return null;
        int val = Integer.parseInt(n);
        return new TreeNode(val);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));