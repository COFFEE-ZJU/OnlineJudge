package cn.edu.zju.coffee.no199;

import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
	private void view(int depth, TreeNode node, List<Integer> list){
		if(node == null || list == null) return;
		
		if(depth > list.size())
			list.add(node.val);
		
		view(depth+1, node.right, list);
		view(depth+1, node.left, list);
	}
	
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> ret = new LinkedList<Integer>();
		view(1, root, ret);
		
		return ret;
    }
}
