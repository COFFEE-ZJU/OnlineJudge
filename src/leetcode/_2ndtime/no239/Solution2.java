package leetcode._2ndtime.no239;

import java.util.PriorityQueue;

/**
 * Whiteboard coding!
 */
public class Solution2 {
    private static class Num implements Comparable<Num>{
        final int idx, num;

        private Num(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }

        @Override
        public int compareTo(Num o) {
            return Integer.compare(o.num, num);
        }
    }

    private PriorityQueue<Num> heap = new PriorityQueue<>();
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len;
        if (nums == null || (len=nums.length) == 0 || k <= 0 || k > len) return new int[0];

        heap.clear();
        for (int i = 0; i < k; i++) {
            heap.add(new Num(i, nums[i]));
        }

        k--;
        int[] res = new int[len-k];
        for (int i = k; i < len; i++) {
            Num num = new Num(i, nums[i]);
            heap.add(num);
            while (!heap.isEmpty()) {
                num = heap.peek();
                if (num.idx < i - k) heap.poll();
                else break;
            }
            res[i-k] = num.num;
        }
        return res;
    }
}
