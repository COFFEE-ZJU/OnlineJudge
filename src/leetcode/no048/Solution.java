package leetcode.no048;

import java.util.Arrays;

/**
 * Created by zkf on 1/7/16.
 */
public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length <= 1)
            return;

        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n-1-i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = tmp;
            }
        }
    }

    private static void print(int[][] m){
        for (int[] mm : m){
            System.out.println(Arrays.toString(mm));
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                new int[]{1,2},
                new int[]{3,4},
//                new int[]{7,8,9},
        };

        Solution sol = new Solution();
        print(matrix);
        sol.rotate(matrix);
        System.out.println();
        print(matrix);
    }
}
