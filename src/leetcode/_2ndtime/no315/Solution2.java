package leetcode._2ndtime.no315;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Whiteboard coding!
 */
public class Solution2 {
    private static class Num implements Comparable<Num>{
        static int ID = 0;
        long sum;
        final int idx;

        private Num(long sum) {
            this.sum = sum;
            idx = ID++;
        }

        @Override
        public int compareTo(Num o) {
            int res = Long.compare(sum, o.sum);
            return res == 0 ? Integer.compare(o.idx, idx) : res;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) return Collections.emptyList();

        List<Integer> res = new LinkedList<>();
        SortedSet<Num> set = new TreeSet<>();
        for (int i = len-1; i >= 0; i--) {
            Num cur = new Num(nums[i]);
            res.add(0, set.headSet(cur).size());
            set.add(cur);
        }
        return res;
    }
}

