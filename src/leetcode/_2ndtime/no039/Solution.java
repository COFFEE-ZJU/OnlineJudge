package leetcode._2ndtime.no039;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Whiteboard coding!
 */
public class Solution {
    private List<List<Integer>> res;
    private List<Integer> list = new ArrayList<>();
    private int target, len;
    private int[] cands;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target <= 0) return Collections.emptyList();

        cands = candidates;
        len = cands.length;
        this.target = target;
        res = new ArrayList<>();

        solve(0, 0);

        return res;
    }

    private void solve(int idx, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (sum > target || idx >= len) return;

        int oriLen = list.size();
        while (sum <= target) {
            solve(idx+1, sum);
            list.add(cands[idx]);
            sum += cands[idx];
        }
        for (int i = list.size(); i > oriLen; i--) {
            list.remove(i-1);
        }
    }

    public static void main(String[] args) {
        new Solution().combinationSum(new int[]{2,3,6,7}, 7);
    }
}