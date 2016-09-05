package leetcode._1sttime.no373;

import java.util.*;

public class Solution {
    private int[] nums1, nums2;
    private class Pair implements Comparable<Pair> {
        private final int i1, i2;

        private Pair(int i1, int i2) {
            this.i1 = i1;
            this.i2 = i2;
        }

        private int[] getPair() {
            return new int[]{nums1[i1], nums2[i2]};
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(nums1[i1]+nums2[i2], nums1[o.i1]+nums2[o.i2]);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (i1 != pair.i1) return false;
            return i2 == pair.i2;

        }

        @Override
        public int hashCode() {
            int result = i1;
            result = 31 * result + i2;
            return result;
        }
    }

    private Comparator<Pair> CMP = new Comparator<Pair>() {
        @Override
        public int compare(Pair o1, Pair o2) {
            return Integer.compare(nums1[o1.i1]+nums2[o1.i2], nums1[o2.i1]+nums2[o2.i2]);
        }
    };

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int l1, l2;
        if (nums1 == null || nums2 == null || k <= 0 ||
                (l1=nums1.length) == 0 || (l2=nums2.length) == 0)
            return Collections.emptyList();
        this.nums1 = nums1;
        this.nums2 = nums2;

        PriorityQueue<Pair> heap = new PriorityQueue<>(CMP);
        Set<Pair> seen = new HashSet<>();
        Pair init = new Pair(0, 0);
        heap.add(init);
        seen.add(init);
        int cnt = 0;
        List<int[]> res = new ArrayList<>();
        while (cnt++ < k && !heap.isEmpty()) {
            Pair cur = heap.poll();
            res.add(cur.getPair());
            if (cur.i1 < l1-1) {
                Pair p = new Pair(cur.i1+1, cur.i2);
                if (seen.add(p))
                    heap.add(p);
            }
            if (cur.i2 < l2-1) {
                Pair p = new Pair(cur.i1, cur.i2+1);
                if (seen.add(p))
                    heap.add(p);
            }
        }
        return res;
    }
}