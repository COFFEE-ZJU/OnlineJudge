package toutiao.screen.n6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一棵n个节点的无向树，树上两个相邻节点之间的边表示他们之间的距离（>0），
 * 对于每个节点u，记sum(u)为它到树上其他所有点的距离之和，求sum(u)最小的节点。
 */
public class Solution {
	private static class Tree {
		List<Tree> children;
		List<Integer> weights;
	}

	private Map<Tree, Integer> sizeMap = new HashMap<>();
	private Map<Tree, Integer> sumMap = new HashMap<>();
	private int size;

	public int getMinSum(Tree root) {
		if (root == null) return 0;

		sizeMap.clear();
		sumMap.clear();
		getSum(root);

		size = sizeMap.size();
		calcSum(root);
		int minSum = Integer.MAX_VALUE;
		for (int val : sumMap.values()) {
			minSum = Math.min(minSum, val);
		}
		return minSum;
	}

	private void calcSum(Tree root) {
		int rootSum = sumMap.get(root);
		for (int i = 0; i < root.children.size(); i++) {
			Tree c = root.children.get(i);
			int w = root.weights.get(i);
			int cSize = sizeMap.get(c);
			int pSize = size - cSize;
			int cSum = rootSum + (pSize - cSize) * w;
			// cSum = rootSum - w * cSize + w * pSize
			sumMap.put(c, cSum);
			calcSum(c);
		}
	}

	private int getSum(Tree root) {
		int sum = 0, size = 1;
		for (int i = 0; i < root.children.size(); i++) {
			Tree c = root.children.get(i);
			int w = root.weights.get(i);
			sum += getSum(c) + w * sizeMap.get(c);
			size += sizeMap.get(c);
		}
		sizeMap.put(root, size);
		return sum;
	}
}