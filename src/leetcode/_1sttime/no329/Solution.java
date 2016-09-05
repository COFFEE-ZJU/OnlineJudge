package leetcode._1sttime.no329;

public class Solution {
    private int[][] matrix;
    private int[][] cache;
    private int r,c;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || (r=matrix.length) == 0 ||
                matrix[0] == null || (c=matrix[0].length) == 0)
            return 0;
        this.matrix = matrix;
        this.cache = new int[r][c];

        int max = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int cur = findLongest(i, j);
                if (cur > max) max = cur;
            }
        }

        return max;
    }

    private int findLongest(int i, int j) {
        if (cache[i][j] != 0) return cache[i][j];

        int max = 0, cur = matrix[i][j];
        if (numAt(i-1, j, Integer.MIN_VALUE) > cur)
            max = Math.max(max, findLongest(i-1, j));
        if (numAt(i+1, j, Integer.MIN_VALUE) > cur)
            max = Math.max(max, findLongest(i+1, j));
        if (numAt(i, j-1, Integer.MIN_VALUE) > cur)
            max = Math.max(max, findLongest(i, j-1));
        if (numAt(i, j+1, Integer.MIN_VALUE) > cur)
            max = Math.max(max, findLongest(i, j+1));

        cache[i][j] = max + 1;
        return max + 1;
    }

    private int numAt(int i, int j, int def) {
        if (i < 0 || i >= r || j < 0 || j >= c) return def;
        else return matrix[i][j];
    }


    public static void main(String[] args) {
		Solution sol = new Solution();
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
