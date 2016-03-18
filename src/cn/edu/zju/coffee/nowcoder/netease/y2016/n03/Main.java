package cn.edu.zju.coffee.nowcoder.netease.y2016.n03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zkf on 3/17/16.
 */
public class Main {
    private static int[][] mat;
    private static class Cell implements Comparable<Cell>{
        final int x, y, count;

        private Cell(int x, int y) {
            this.x = x;
            this.y = y;
            int c = mat[x][y];
            c += mat[x-1][y];
            c += mat[x+1][y];
            c += mat[x][y-1];
            c += mat[x][y+1];
            c += mat[x-1][y-1];
            c += mat[x-1][y+1];
            c += mat[x+1][y-1];
            c += mat[x+1][y+1];
            count = c;
        }

        private boolean contains(int xx, int yy) {
            return (Math.abs(xx - x) <= 1 && Math.abs(yy - y) <= 1);
        }

        private boolean overlaps(Cell o) {
            return (Math.abs(o.x - x) <= 2 && Math.abs(o.y - y) <= 2);
        }

        private int sums(Cell o) {
            int cnt = count + o.count;
            if (o.contains(x, y)) cnt -= mat[x][y];
            if (o.contains(x-1, y)) cnt -= mat[x-1][y];
            if (o.contains(x+1, y)) cnt -= mat[x+1][y];
            if (o.contains(x, y-1)) cnt -= mat[x][y-1];
            if (o.contains(x, y+1)) cnt -= mat[x][y+1];
            if (o.contains(x-1, y-1)) cnt -= mat[x-1][y-1];
            if (o.contains(x-1, y+1)) cnt -= mat[x-1][y+1];
            if (o.contains(x+1, y-1)) cnt -= mat[x+1][y-1];
            if (o.contains(x+1, y+1)) cnt -= mat[x+1][y+1];
            return cnt;
        }

        @Override
        public int compareTo(Cell o) {
            return Integer.compare(o.count, count);
        }
    }
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            int r = scanner.nextInt(), c = scanner.nextInt(), k = scanner.nextInt();
            mat = new int[r+2][c+2];
            Cell[][] matCent = new Cell[r+2][c+2];
            for (int i = 0; i < k; i++)
                mat[scanner.nextInt()][scanner.nextInt()] ++;

            int max = 0;
            List<Cell> cells = new ArrayList<>(c * r);
            for (int i = 1; i <= r; i++) {
                for (int j = 1; j <= c; j++) {
                    Cell cell = new Cell(i, j);
                    cells.add(cell);
                    matCent[i][j] = cell;
                }
            }
            Collections.sort(cells);
            for (int i = 1; i <= r; i++) {
                for (int j = 1; j <= c; j++) {
                    Cell curC = matCent[i][j];
                    for (Cell cell : cells) {
                        max = Math.max(max, curC.sums(cell));
                        if (!curC.overlaps(cell))
                            break;
                    }
                }
            }
            System.out.println(max);
        }
    }
}
