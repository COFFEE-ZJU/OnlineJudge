package leetcode._2ndtime.no329;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private static int[][] DIRS = new int[][]{new int[]{-1, 0}, new int[]{1, 0}, new int[]{0, -1}, new int[]{0, 1} };
    private int[][] matrix;
    private int[][] inDeg;
    private int r,c;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || (r=matrix.length) == 0 ||
                matrix[0] == null || (c=matrix[0].length) == 0)
            return 0;
        this.matrix = matrix;
        this.inDeg = new int[r+2][c+2];
        for (int i = 0; i < r + 2; i++) {
            inDeg[i][0] = Integer.MAX_VALUE;
            inDeg[i][c+1] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < c + 2; i++) {
            inDeg[0][i] = Integer.MAX_VALUE;
            inDeg[r+1][i] = Integer.MAX_VALUE;
        }

        List<Integer> iPos = new LinkedList<>();
        List<Integer> jPos = new LinkedList<>();
        List<Integer> lens = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int deg = 0, cur = matrix[i][j];
                for (int[] dir : DIRS) {
                    if (numAt(i+dir[0], j+dir[1], Integer.MAX_VALUE) < cur)
                        deg++;
                }

                inDeg[i+1][j+1] = deg;
                if (deg == 0) {
                    iPos.add(i + 1);
                    jPos.add(j + 1);
                    lens.add(1);
                }
            }
        }

        int max = 0;
        while (!lens.isEmpty()) {
            int i = iPos.remove(0), j = jPos.remove(0), len = lens.remove(0);
            max = Math.max(max, len);
            for (int[] dir : DIRS) {
                int cur = matrix[i-1][j-1];
                if (numAt(i-1+dir[0], j-1+dir[1], Integer.MIN_VALUE) > cur &&
                        (--inDeg[i+dir[0]][j+dir[1]]) == 0) {
                    iPos.add(i+dir[0]);
                    jPos.add(j+dir[1]);
                    lens.add(len+1);
                }
            }
        }
        return max;
    }

    private int numAt(int i, int j, int def) {
        if (i < 0 || i >= r || j < 0 || j >= c) return def;
        else return matrix[i][j];
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestIncreasingPath(new int[][]{
                new int[]{0,1,5,5},
        }));

        System.out.println(sol.longestIncreasingPath(new int[][]{
                new int[]{9,9,4},
                new int[]{6,6,8},
                new int[]{2,1,1},
        }));

        System.out.println(sol.longestIncreasingPath(new int[][]{
                new int[]{3,4,5,},
                new int[]{3,2,6,},
                new int[]{2,2,1},
        }));
    }
}
