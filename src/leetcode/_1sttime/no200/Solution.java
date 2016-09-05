package leetcode._1sttime.no200;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private int r,c;
    private char[][] grid;
    private int islandCnt;
    private List<int[]> list = new LinkedList<>();
    public int numIslands(char[][] grid) {
        if (grid == null || (r=grid.length) == 0 ||
                grid[0] == null || (c=grid[0].length) == 0)
            return 0;
        this.grid = grid;
        islandCnt = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') mark(i, j);
            }
        }

        return islandCnt;
    }

    private void mark(int i, int j){

        islandCnt++;
        list.clear();
        list.add(new int[]{i,j});
        while (!list.isEmpty()){
            int[] pos = list.remove(0);
            int ii = pos[0], jj = pos[1];

            if (ii < 0 || ii >= r || jj < 0 || jj >= c)
                continue;
            if (grid[ii][jj] != '1')
                continue;
            grid[ii][jj]++;
            list.add(new int[]{ii-1, jj});
            list.add(new int[]{ii+1, jj});
            list.add(new int[]{ii, jj-1});
            list.add(new int[]{ii, jj+1});
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
    }
}
