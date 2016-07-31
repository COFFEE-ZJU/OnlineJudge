package leetcode.no377;

import java.util.HashMap;
import java.util.Map;

/**
 * Whiteboard coding!
 */
public class Solution {
    private final Map<Integer, Integer> cache = new HashMap<>();
    private int[] nums;

    public int combinationSum4(int[] nums, int target) {
        if (target == 0) return 1;
        if (nums == null || nums.length == 0 || target <= 0) {
            return 0;
        }

        this.nums = nums;
        cache.clear();
        return cmb(target);
    }

    private int cmb(int target) {
        if (target == 0) return 1;

        Integer res = cache.get(target);
        if (res != null) return res;

        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                cnt += cmb(target - nums[i]);
            }
        }

        cache.put(target, cnt);
        return cnt;
    }
}