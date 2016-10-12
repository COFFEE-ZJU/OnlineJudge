package leetcode._2ndtime.no149;

import java.util.HashMap;
import java.util.Map;

import leetcode.Point;

/**
 * Whiteboard coding!
 */

public class Solution {
    private static class Ratio {
        final long dy, dx;

        private Ratio(long dy, long dx) {
            if (dx == 0) {
                this.dx = 0;
                this.dy = 1;
            } else if (dy == 0) {
                this.dx = 1;
                this.dy = 0;
            } else {
                boolean isPos = (dy > 0 && dx >0) || (dy < 0 && dx < 0);
                dy = Math.abs(dy);
                dx = Math.abs(dx);
                long gcd = gcd(dy, dx);
                this.dy = isPos ? dy / gcd : -dy / gcd;
                this.dx = dx / gcd;
            }
        }

        private static long gcd(long x, long y) {
            long z = x % y;
            return z == 0 ? y : gcd(y, z);
        }

        @Override
        public boolean equals(Object o) {
            Ratio ratio = (Ratio) o;

            if (dy != ratio.dy) {
                return false;
            }
            return dx == ratio.dx;
        }

        @Override
        public int hashCode() {
            int result = (int) (dy ^ (dy >>> 32));
            result = 31 * result + (int) (dx ^ (dx >>> 32));
            return result;
        }
    }

    private int curMax;
    private Map<Ratio, Integer> cntMap = new HashMap<>();

    public int maxPoints(Point[] points) {
        int len = 0;
        if (points == null || (len = points.length) <= 2) return len;

        int max = 2;
        for (Point p1 : points) {
            cntMap.clear();
            curMax = 0;
            int curCnt = 0;
            for (Point p2 : points) {
                if (p1.x == p2.x && p1.y == p2.y) {
                    curCnt++;
                    continue;
                }
                updateCnt(p1, p2);
            }
            max = Math.max(max, curMax + curCnt);
        }
        return max;
    }

    private void updateCnt(Point p1, Point p2) {
        long dy = p2.y - p1.y, dx = p2.x - p1.x;
        Ratio ratio = new Ratio(dy, dx);
        Integer cnt = cntMap.get(ratio);
        if (cnt == null) cnt = 1;
        else cnt++;

        curMax = Math.max(curMax, cnt);
        cntMap.put(ratio, cnt);
    }
}