package leetcode._2ndtime.no078;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Whiteboard coding!
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Collections.emptyList());

        for (int n : nums) {
            int len = res.size();
            for (int i = 0; i < len; i++) {
                List<Integer> l = new ArrayList<>(res.get(i));
                l.add(n);
                res.add(l);
            }
        }
        return res;
    }
}