package leetcode._2ndtime.no218;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Whiteboard coding!
 */

public class Solution {
    private static class Point {
        final int x, y;
        final boolean isStart;

        private Point(int x, int y, boolean isStart) {
            this.x = x;
            this.y = y;
            this.isStart = isStart;
        }
    }
    private static Comparator<Point> byX = new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            return Integer.compare(o1.x, o2.x);
        }
    };
    private static Comparator<Point> byY = new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            int res = Integer.compare(o1.y, o2.y);
            return res == 0 ? Integer.compare(o1.x, o2.x) : res;
        }
    };

    public List<int[]> getSkyline(int[][] buildings) {
        int len;
        if (buildings == null || (len = buildings.length) == 0) return Collections.emptyList();

        List<Point> points = new ArrayList<>(2 * len);
        Map<Point, Point> map = new HashMap<>();
        for (int[] bd : buildings) {
            Point st = new Point(bd[0], bd[2], true);
            Point end = new Point(bd[1], bd[2], false);
            points.add(st);
            points.add(end);
            map.put(end, st);
        }
        Collections.sort(points, byX);

        int prevY = 0;
        List<int[]> res = new ArrayList<>();
        SortedSet<Point> set = new TreeSet<>(byY);
        set.add(new Point(Integer.MIN_VALUE, 0, true));
        for (int i = 0; i < points.size();) {
            Point p = points.get(i);
            int curX = p.x;
            while (i < points.size() && p.x == curX) {
                if (p.isStart) set.add(p);
                else set.remove(map.get(p));
                i++;
                if (i == points.size()) break;
                else p = points.get(i);
            }

            int curY = set.last().y;
            if (curY != prevY) {
                prevY = curY;
                res.add(new int[]{curX, curY});
            }
        }

        return res;
    }

    public static void main(String[] args) {
        new Solution().getSkyline(new int[][]{
            new int[]{0, 1, 3}
        });
    }
}