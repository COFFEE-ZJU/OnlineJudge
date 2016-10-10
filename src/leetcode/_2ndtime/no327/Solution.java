package leetcode._2ndtime.no327;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Whiteboard coding!
 */

public class Solution {
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
            return res == 0 ? Integer.compare(idx, o.idx) : res;
        }
    }
    public int countRangeSum(int[] nums, int lower, int upper) {
        int len;
        if (nums == null || (len = nums.length) == 0) return 0;

        long[] sums = new long[len+1];
        for (int i = 1; i <= len; i++) {
            sums[i] = sums[i-1] + nums[i-1];
        }
        SortedSet<Num> set = new TreeSet<>();
        int cnt = 0;
        Num u = new Num(0), l = new Num(0);
        for (int i = 0; i <= len; i++) {
            u.sum = sums[i] - lower + 1;
            l.sum = sums[i] - upper;
            cnt += set.subSet(l, u).size();
            set.add(new Num(sums[i]));
        }
        return cnt;
    }
}