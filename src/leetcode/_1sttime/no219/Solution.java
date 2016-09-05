package leetcode._1sttime.no219;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<Integer, Integer> map = new HashMap<>();
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k <= 0)
            return false;

        map.clear();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer idx = map.get(num);
            if (idx != null && (i-idx) <= k)
                return true;

            map.put(num, i);
        }

        return false;
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
    }
}
