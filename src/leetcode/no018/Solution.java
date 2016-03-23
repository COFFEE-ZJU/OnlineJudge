package leetcode.no018;

import java.util.*;

/**
 * Created by zkf on 2015/12/18.
 */
public class Solution {
	public List<List<Integer>> fourSum(int[] nums, int target) {

		Set<Quadruplet> set = new HashSet<>();
		if(nums == null || nums.length < 3)
			return toList(set);

		Map<Integer, List<int[]>> pairs = new HashMap<>();
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int key = nums[i] + nums[j];
				List<int[]> list = pairs.get(key);
				if(list == null){
					list = new LinkedList<>();
					pairs.put(key, list);
				}
				list.add(new int[]{i, j});
			}
		}

		for (Map.Entry<Integer, List<int[]>> entry : pairs.entrySet()){
			List<int[]> list1 = entry.getValue();
			List<int[]> list2 = pairs.get(target - entry.getKey());
			if(list2 == null)
				continue;

			for (int[] p1 : list1){
				for (int[] p2 : list2){
					if(isValid(p1, p2))
						set.add(new Quadruplet(nums[p1[0]], nums[p1[1]], nums[p2[0]], nums[p2[1]]));
				}
			}
		}

		return toList(set);
	}

	private boolean isValid(int[] a, int[] b){
		return  (a[0] != b[0] && a[0] != b[1] && a[1] != b[0] && a[1] != b[1]);
	}

	private List<List<Integer>> toList(Set<Quadruplet> set){
		List<List<Integer>> list = new LinkedList<>();
		for (Quadruplet t : set)
			list.add(t.toList());

		return list;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().fourSum(new int[]{-3,-1,0,2,4,5}, 0));
	}

	static class Quadruplet{
		final List<Integer> list;
		public Quadruplet(int a, int b, int c, int d) {
			list = Arrays.asList(a, b, c, d);
			Collections.sort(list);
		}

		List<Integer> toList(){
			return list;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Quadruplet quadruplet = (Quadruplet) o;
			return list.equals(quadruplet.list);
		}

		@Override
		public int hashCode() {
			return list.hashCode();
		}
	}
}
