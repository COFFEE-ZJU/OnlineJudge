package leetcode._2ndtime.no363;

import java.util.Arrays;
import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * Whiteboard coding!
 */

public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int r,c;
        if (matrix == null || (r = matrix.length) == 0 ||
                matrix[0] == null || (c = matrix[0].length) == 0) return 0;

        int[] sums = new int[c];
        NavigableSet<Integer> set = new TreeSet<>();
        int max = Integer.MIN_VALUE;
        for (int str = 0; str < r; str++) {
            Arrays.fill(sums, 0);
            for (int endr = str; endr < r; endr++) {
                int curSum = 0;
                set.clear();
                set.add(0);
                for (int cc = 0; cc < c; cc++) {
                    curSum += matrix[endr][cc];
                    sums[cc] += curSum;

                    int tgt = sums[cc] - k;
                    Integer sub = set.ceiling(tgt);
                    if (sub != null) {
                        max = Math.max(sums[cc] - sub, max);
                    }
                    set.add(sums[cc]);
                }
            }
        }

        return max;
    }
}