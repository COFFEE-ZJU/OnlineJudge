package leetcode.no352;

import java.util.*;

public class SummaryRanges {
    TreeSet<Interval> set = new TreeSet<>(new Comparator<Interval>() {
        @Override
        public int compare(Interval o1, Interval o2) {
            return Integer.compare(o1.start, o2.start);
        }
    });

    /** Initialize your data structure here. */
    public SummaryRanges() {

    }

    public void addNum(int val) {
        Interval interval = new Interval(val, val);
        Interval pred = set.floor(interval), succ = set.ceiling(interval);
        if (pred == null && succ == null) {
            set.add(interval);
            return;
        }

        if (pred != null) {
            if (pred.end >= val) return;
            if (pred.end == val - 1) {
                if (succ != null && succ.start == val + 1) {
                    set.remove(succ);
                    pred.end = succ.end;
                }
                else
                    pred.end++;

                return;
            }
        }
        if (succ != null) {
            if (succ.start <= val) return;
            if (succ.start == val + 1) {
                set.remove(succ);
                succ.start--;
                set.add(succ);
            }
            else
                set.add(interval);
        }


    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(set);
    }
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}