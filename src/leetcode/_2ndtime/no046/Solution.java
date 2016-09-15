package leetcode._2ndtime.no046;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Whiteboard coding!
 */
public class Solution {
    private int[] nums;
    private boolean[] occr;
    private int len;
    private List<List<Integer>> res;
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || (len = nums.length) == 0) return Collections.emptyList();

        this.nums = nums;
        occr = new boolean[len];
        res = new ArrayList<>();
        solve(0);
        return res;
    }

    private void solve(int idx) {
        if (idx == len) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (occr[i]) continue;

            occr[i] = true;
            list.add(nums[i]);

            solve(idx+1);

            list.remove(list.size()-1);
            occr[i] = false;
        }
    }
}