package leetcode._2ndtime.no264;

import java.util.LinkedList;
import java.util.List;

/**
 * Whiteboard coding!
 */
public class Solution {
    List<Integer> by2 = new LinkedList<>();
    List<Integer> by3 = new LinkedList<>();
    List<Integer> by5 = new LinkedList<>();

    public int nthUglyNumber(int n) {
        if (n <= 1) return 1;

        by2.clear();
        by3.clear();
        by5.clear();
        int[] unums = new int[n];
        unums[0] = 1;
        by2.add(2);
        by3.add(3);
        by5.add(5);
        for (int i = 1; i < n; i++) {
            int c2 = by2.get(0), c3 = by3.get(0), c5 = by5.get(0);
            int min = Math.min(Math.min(c2, c3), c5);
            if (c2 == min) by2.remove(0);
            if (c3 == min) by3.remove(0);
            if (c5 == min) by5.remove(0);
            unums[i] = min;
            by2.add(min * 2);
            by3.add(min * 3);
            by5.add(min * 5);
        }

        return unums[n-1];
    }
}