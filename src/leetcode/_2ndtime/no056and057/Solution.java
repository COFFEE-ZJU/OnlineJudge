package leetcode._2ndtime.no056and057;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import leetcode.Interval;

/**
 * Whiteboard coding!
 */
public class Solution {
    private static final Comparator<Interval> comp = new Comparator<Interval>() {
        @Override
        public int compare(Interval o1, Interval o2) {
            return Integer.compare(o1.start, o2.start);
        }
    };

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int idx = Collections.binarySearch(intervals, newInterval, comp);
        if (idx < 0) {
            idx = -idx - 1;
        }
        intervals.add(idx, newInterval);
        return merge(intervals);
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) return Collections.emptyList();

        Collections.sort(intervals, comp);
        List<Interval> res = new ArrayList<>();
        Interval cur = intervals.get(0);
        for (Interval itv : intervals) {
            if (itv.start <= cur.end) {
                cur.end = Math.max(cur.end, itv.end);
            } else {
                res.add(cur);
                cur = itv;
            }
        }
        res.add(cur);
        return res;
    }
}