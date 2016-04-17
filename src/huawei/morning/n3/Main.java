package huawei.morning.n3;

import java.util.Scanner;

/**
 * Created by Zhangkefei on 2016/4/16.
 */
public class Main {

    public static int count(int[][] matrix, int r, int c) {
        int[][] dp = new int[r+1][c+1];
        int max = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) continue;

                dp[i+1][j+1] = Math.min(Math.min(dp[i][j], dp[i+1][j]), dp[i][j+1]) + 1;
                max = Math.max(dp[i+1][j+1], max);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int r = scanner.nextInt(), c = scanner.nextInt();
            int[][] matrix = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            System.out.println(count(matrix, r, c));
        }
    }
}
