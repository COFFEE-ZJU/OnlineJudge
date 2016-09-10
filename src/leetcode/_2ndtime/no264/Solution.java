package leetcode._2ndtime.no264;

import java.util.PriorityQueue;

/**
 * Whiteboard coding!
 */
public class Solution {
    private PriorityQueue<Long> heap = new PriorityQueue<>();
    public int nthUglyNumber(int n) {
        if (n <= 0) return 1;
        heap.clear();
        heap.add(1l);
        int prev = 0;
        for (int i = 0; i < n; i++) {
            long num = heap.poll();
            while (num == prev) num = heap.poll();
            prev = (int)num;
            heap.add(num * 2);
            heap.add(num * 3);
            heap.add(num * 5);
        }
        return prev;
    }
}