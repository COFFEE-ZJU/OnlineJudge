package leetcode._2ndtime.no128;

import java.util.HashMap;
import java.util.Map;

/**
 * Whiteboard coding!
 */
public class Solution2 {
	private Map<Integer, Integer> map = new HashMap<>();
	private int maxLen;
	public int longestConsecutive(int[] nums) {
		map.clear();
		maxLen = 0;
		for (int n : nums) {
			Integer range = map.get(n);
			if (range != null) continue;
			map.put(n, 0);
			merge(n-1, n);
			merge(n, n+1);
		}

		return maxLen+1;
	}

	private void merge(int a, int b) {
		Integer left = map.get(a), right = map.get(b);
		if (left == null || right == null || left > 0 || right < 0) return;
		int lBound = a+left, rBound = b+right;
		int newLen = right - left + 1;
		map.put(lBound, newLen);
		map.put(rBound, -newLen);
		maxLen = Math.max(maxLen, newLen);
	}
}