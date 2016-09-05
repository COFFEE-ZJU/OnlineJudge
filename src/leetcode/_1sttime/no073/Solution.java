package leetcode._1sttime.no073;

import java.util.Arrays;

public class Solution {
    /**
     * O(1) space
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 ||
                matrix[0] == null || matrix[0].length == 0)
            return;

        int r = matrix.length, c = matrix[0].length;
        int br = -1, bc = -1;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    if (br == -1) {
                        br = i;
                        bc = j;
                    }
                    else if (i == br || j == bc)
                        continue;
                    else
                        matrix[i][bc] = 0;
                        matrix[br][j] = 0;
                }
            }
        }

        if (br == -1)
            return;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if ((matrix[i][bc] == 0 || matrix[br][j] == 0) &&
                        i != br && j != bc)
                    matrix[i][j] = 0;
            }
        }

        for (int k = 0; k < r; k++)
            matrix[k][bc] = 0;
        for (int k = 0; k < c; k++)
            matrix[br][k] = 0;
    }


    /**
     * O(m + n) space
     * @param matrix
     */
	public void setZeroes2(int[][] matrix) {
		if (matrix == null || matrix.length == 0 ||
                matrix[0] == null || matrix[0].length == 0)
            return;

        int r = matrix.length, c = matrix[0].length;
        boolean[] rows = new boolean[r], cols = new boolean[c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (rows[i] || cols[j])
                    matrix[i][j] = 0;
            }
        }
    }

    private static void print(int[][] m){
        for (int[] r : m)
            System.out.println(Arrays.toString(r));
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        int[][] matrix = new int[][]{
                new int[]{0,0,0,5},
                new int[]{4,3,1,4},
                new int[]{0,1,1,4},
                new int[]{1,2,1,3},
                new int[]{0,0,1,1},
        };
        sol.setZeroes(matrix);
        print(matrix);
	}
}