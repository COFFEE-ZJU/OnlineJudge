package leetcode._1sttime.no144;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
        	TreeNode node = stack.pop();
			list.add(node.val);
			if(node.right != null) stack.push(node.right);
			if(node.left != null) stack.push(node.left);
        }
        
        return list;
    }
}
