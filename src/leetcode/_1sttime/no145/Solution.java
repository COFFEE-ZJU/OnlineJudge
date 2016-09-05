package leetcode._1sttime.no145;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
        	TreeNode node = stack.peek();
        	if(node.left == null && node.right == null){
        		list.add(node.val);
        		stack.pop();
        	}
        	else{
        		if(node.right != null) stack.push(node.right);
        		if(node.left != null) stack.push(node.left);
            	node.left = node.right = null;
        	}
        }
        
        return list;
    }
}
