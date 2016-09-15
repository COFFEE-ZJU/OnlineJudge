package leetcode._2ndtime.no047;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Whiteboard coding!
 */
public class Solution {
    private static class Num {
        int num, cnt;
        Num(int n) {
            num = n;
            cnt = 1;
        }
    }
    private List<Num> nums = new ArrayList<>();
    private int len;
    private List<List<Integer>> res;
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || (len=nums.length) == 0) return Collections.emptyList();

        Arrays.sort(nums);
        Num prev = new Num(nums[0]);
        this.nums.clear();
        this.nums.add(prev);

        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (cur == prev.num) {
                prev.cnt++;
            } else {
                prev = new Num(cur);
                this.nums.add(prev);
            }
        }

        res = new ArrayList<>();

        solve(0);

        return res;
    }

    private void solve(int idx) {
        if (idx == len) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (Num n : nums) {
            if (n.cnt == 0) continue;

            n.cnt--;
            list.add(n.num);

            solve(idx+1);

            n.cnt++;
            list.remove(list.size()-1);
        }
    }
}