package leetcode._1sttime.no149;

import leetcode.Point;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxPoints(Point[] points) {
        if (points == null) return 0;
        int len = points.length;
        if (len <= 2) return len;

        Map<Double, Integer> slopeCnt = new HashMap<>();
        int max = 1;
        for (int i = 0; i < len-1; i++) {
            slopeCnt.clear();
            int sameOne = 0, innerMax = 1;
            Point p1 = points[i];
            for (int j = i+1; j < len; j++) {
                Point p2 = points[j];
                if (p1.x == p2.x && p1.y == p2.y){
                    sameOne ++;
                    continue;
                }

                Double slope = Double.MAX_VALUE;
                if (p1.x != p2.x)
                    slope = (p1.y == p2.y) ? 0.0 : 1.0 * (p2.y - p1.y) / (p2.x - p1.x);
                int cnt = slopeCnt.getOrDefault(slope, 1);
                cnt++;
                slopeCnt.put(slope, cnt);
                if (cnt > innerMax) innerMax = cnt;
            }
            innerMax += sameOne;
            if (innerMax > max) max = innerMax;
        }

        return max;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        Point[] ps = new Point[]{
                new Point(2,3),
                new Point(3,3),
                new Point(-5,3),
        };
        System.out.println(sol.maxPoints(ps));
    }
}
