package cn.edu.zju.coffee.nowcoder.netease.y2016.n03;

import java.util.*;

/**
 * Created by zkf on 3/17/16.
 */
public class Main {
    private static int[][] mat;
    private static int[] dx = new int[]{0, -1, 1, 0, 0, -1, -1, 1, 1};
    private static int[] dy = new int[]{0, 0, 0, -1, 1, -1, 1, -1, 1};
    private static class Cell implements Comparable<Cell>{
        final int x, y, count;

        private Cell(int x, int y) {
            this.x = x;
            this.y = y;
            count = reCount();
        }

        private int reCount() {
            int c = 0;
            for (int i = 0; i < 9; i++) {
                if (mat[x+dx[i]][y+dy[i]] > 0)
                    c++;
            }
            return c;
        }

        @Override
        public int compareTo(Cell o) {
            return Integer.compare(o.count, count);
        }
    }
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextInt()) {
                int r = scanner.nextInt(), c = scanner.nextInt(), k = scanner.nextInt();
                mat = new int[r + 2][c + 2];
                Cell[][] matCent = new Cell[r + 2][c + 2];
                for (int i = 0; i < k; i++)
                    mat[scanner.nextInt()][scanner.nextInt()]++;

//                for (int[] row : mat)
//                    System.out.println(Arrays.toString(row));

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
                        int x = matCent[i][j].x, y = matCent[i][j].y;
                        int cnt = matCent[i][j].count;
                        for (int l = 0; l < 9; l++)
                            mat[x+dx[l]][y+dy[l]]--;

                        int n = Math.min(10, cells.size());
                        for (int l = 0; l < n; l++) {
                            Cell cell = cells.get(l);
                            max = Math.max(max, cnt + cell.reCount());
                        }

                        for (int l = 0; l < 9; l++)
                            mat[x+dx[l]][y+dy[l]]++;
                    }
                }
                System.out.println(max);
            }
        }
    }
}
