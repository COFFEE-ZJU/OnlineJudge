package leetcode.contest08.n3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    private int[][] m;
    private int r,c;
    private int[][] status;
    public List<int[]> pacificAtlantic(int[][] matrix) {
        m = matrix;
        if (m == null || (r = m.length) == 0 || m[0] == null || (c = m[0].length) == 0)
            return Collections.emptyList();

        status = new int[r][c];
        for (int i = 0; i < r; i++) {
            touch(i, 0, 1, -1);
        }
        for (int i = 0; i < c; i++) {
            touch(0, i, 1, -1);
        }

        for (int i = 0; i < r; i++) {
            touch(i, c-1, 2, -1);
        }
        for (int i = 0; i < c; i++) {
            touch(r-1, i, 2, -1);
        }

        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (status[i][j] == 3) res.add(new int[]{i, j});
            }
        }
        return res;
    }

    private void touch(int ri, int ci, int mark, int prevH) {
        if (ri < 0 || ri >= r || ci < 0 || ci >= c ||
                status[ri][ci] >= mark || m[ri][ci] < prevH) return;
        status[ri][ci] += mark;
        touch(ri - 1, ci, mark, m[ri][ci]);
        touch(ri + 1, ci, mark, m[ri][ci]);
        touch(ri, ci - 1, mark, m[ri][ci]);
        touch(ri, ci + 1, mark, m[ri][ci]);
    }

}