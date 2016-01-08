package cn.edu.zju.coffee.leetcode.no056and057;

import java.util.*;

/**
 * Created by Zhangkefei on 2016/1/6.
 */
public class Solution {
    private static final Comparator<Interval> COMPARATOR = new Comparator<Interval>() {
        @Override
        public int compare(Interval o1, Interval o2) {
            return Integer.compare(o1.start, o2.start);
        }
    };

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (newInterval == null)
            return intervals;

        if (intervals == null)
            return Collections.singletonList(newInterval);

        List<Interval> list = new LinkedList<>(intervals);
        list.add(0, new Interval(Integer.MIN_VALUE, Integer.MIN_VALUE));
        list.add(new Interval(Integer.MAX_VALUE, Integer.MAX_VALUE));

        int sIdx = 0;
        for (Iterator<Interval> it = list.iterator(); it.hasNext();){
            Interval in = it.next();
            if (newInterval.start > in.start && newInterval.start <= in.end) {
                newInterval.start = in.start;
                if (newInterval.end < in.end)
                    newInterval.end = in.end;

                it.remove();
            }
            else if (newInterval.start <= in.start && newInterval.end >= in.end)
                it.remove();
            else if (newInterval.end < in.end && newInterval.end >= in.start) {
                newInterval.end = in.end;
                if (newInterval.start > in.start)
                    newInterval.start = in.start;
                it.remove();
            }
        }

        int idx = 0;
        for (Interval in : list){
            if (in.start < newInterval.start)
                idx ++;
            else
                break;
        }

        list.add(idx, newInterval);
        list.remove(0);
        list.remove(list.size() - 1);
        return list;
    }

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, COMPARATOR);
        List<Interval> res = new LinkedList<>();
        for (Interval in : intervals){
            if (res.isEmpty())
                res.add(in);
            Interval prev = res.get(res.size() - 1);
            if (prev.end < in.start)
                res.add(in);
            else if (prev.end < in.end)
                prev.end = in.end;
        }

        return res;
    }

    private static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        System.out.println(sol.merge(Arrays.asList(
//                new Interval(1,3),
//                new Interval(2,6),
//                new Interval(8,10),
//                new Interval(15,18)
//        )));

        System.out.println(sol.insert(Arrays.asList(
                new Interval(1,3),
                new Interval(6,9)
        ), new Interval(2,5)));

        System.out.println(sol.insert(Arrays.asList(
                new Interval(1,2),
                new Interval(3,5),
                new Interval(6,7),
                new Interval(8,10),
                new Interval(12,16)
        ), new Interval(-1,0)));
    }
}

