package leetcode._2ndtime.no040;

import java.util.ArrayList;
import java.util.Arrays;
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

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target <= 0) return Collections.emptyList();

        cands = candidates;
        Arrays.sort(cands);
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
        int cur = cands[idx++];
        int cnt = 1;
        while (idx < len && cands[idx] == cur) {
            cnt++;
            idx++;
        }

        for (int i = 0; i <= cnt; i++) {
            solve(idx, sum);

            sum += cur;
            list.add(cur);
        }

        for (int i = list.size(); i > oriLen; i--) {
            list.remove(i-1);
        }
    }

    public static void main(String[] args) {
        new Solution().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
    }
}