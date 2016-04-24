package leetcode._2ndtime.no128;

import java.util.HashMap;
import java.util.Map;

/**
 * Whiteboard coding!
 */
public class Solution {
	private int maxSize;
	private int[] id, size;
	private int len;
	private Map<Integer, Integer> idMap = new HashMap<>();

	private int find(int i) {
		while (i != id[i]) {
			id[i] = id[id[i]];
			i = id[i];
		}

		return i;
	}

	private void union(int i1, int i2) {
		int id1 = find(i1), id2 = find(i2);
		if (id1 == id2) return;

		if (size[id1] < size[id2]) {
			id[id1] = id2;
			size[id2] += size[id1];
			maxSize = Math.max(maxSize, size[id2]);
		}
		else {
			id[id2] = id1;
			size[id1] += size[id2];
			maxSize = Math.max(maxSize, size[id1]);
		}
	}

	public int longestConsecutive(int[] nums) {
		if (nums == null || (len = nums.length) <= 0) return 0;

		idMap.clear();
		id = new int[len];
		size = new int[len];
		maxSize = 1;
		for (int i = 0; i < len; i++) {
			id[i] = i;
			size[i] = 1;
		}
		for (int i = 0; i < len; i++) {
			int num = nums[i];
			if (idMap.containsKey(num)) continue;

			idMap.put(num, i);
			Integer lIdx = idMap.get(num-1), rIdx = idMap.get(num+1);
			if (lIdx != null) union(i, lIdx);
			if (rIdx != null) union(i, rIdx);
		}

		return maxSize;
	}
    
    public static void main(String[] args) {
		System.out.println(new Solution().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
	}
}