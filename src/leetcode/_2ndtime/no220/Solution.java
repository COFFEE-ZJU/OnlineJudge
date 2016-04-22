package leetcode._2ndtime.no220;

import java.util.TreeMap;

public class Solution {
    private TreeMap<Integer, Integer> map = new TreeMap<>();
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length <= 1 || k <= 0 || t < 0)
            return false;

        map.clear();
        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                Integer cnt = map.get(nums[i-k]);
                cnt--;
                if (cnt == 0)
                    map.remove(nums[i-k]);
                else
                    map.put(nums[i-k], cnt);
            }
            Integer ceil = map.ceilingKey(nums[i]),
                    floor = map.floorKey(nums[i]);
            if ((ceil != null && (long)ceil - (long)nums[i] <= (long)t) ||
                    (floor != null && (long)nums[i] - (long)floor <= (long)t))
                return true;

            Integer cnt = map.get(nums[i]);
            if (cnt == null)
                cnt = 1;
            else
                cnt++;
            map.put(nums[i], cnt);
        }

        return false;
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.containsNearbyAlmostDuplicate(new int[]{-3,3},2,4));
    }
}
