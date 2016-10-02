package leetcode._2ndtime.no240;

/**
 * Whiteboard coding!
 */

public class Solution {
    private int r, c, t;
    private int[][] m;
    public boolean searchMatrix(int[][] matrix, int target) {
        m = matrix;
        t = target;
        if (m == null || (r = m.length) == 0 || m[0] == null || (c = m[0].length) == 0)
            return false;

        return search(0, c-1);
    }

    private boolean search(int ri, int ci) {
        if (ri >= r || ci < 0) return false;
        int cur = m[ri][ci];
        if (cur == t) return true;
        else if (cur > t) return search(ri, ci-1);
        else return search(ri+1, ci);
    }
}