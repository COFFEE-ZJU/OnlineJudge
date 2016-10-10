package leetcode._2ndtime.no174;

import java.util.Arrays;

/**
 * Whiteboard coding!
 */

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int r,c;
        if (dungeon == null || (r = dungeon.length) == 0 ||
                dungeon[0] == null || (c = dungeon[0].length) == 0) return 0;

        int[] min = new int[c+1];
        Arrays.fill(min, Integer.MAX_VALUE);
        min[c] = 1;
        for (int i = r-1; i >= 0; i--) {
            for (int j = c-1; j >= 0; j--) {
                min[j] = Math.max(1, Math.min(min[j], min[j+1]) - dungeon[i][j]);
            }
            min[c] = Integer.MAX_VALUE;
        }
        return min[0];
    }
}