package cn.edu.zju.coffee.nowcoder.netease.y2016.n03;

import java.util.Scanner;

/**
 * Created by zkf on 3/17/16.
 */
public class Main {
    private static class Cell implements Comparable<Cell>{
        int x, y;

        @Override
        public int compareTo(Cell o) {
            return 0;
        }
    }
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            int r = scanner.nextInt(), c = scanner.nextInt(), k = scanner.nextInt();
            int[][] mat = new int[r+2][c+2];
            int[][] matCent = new int[r+2][c+2];
            for (int i = 0; i < k; i++)
                mat[scanner.nextInt()][scanner.nextInt()] ++;

            int max = 0;
            for (int i = 1; i <= r; i++) {

            }
        }
    }
}
