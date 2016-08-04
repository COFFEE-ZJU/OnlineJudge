package nowcoder.netease.y2016_4.n02;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Zhangkefei on 2016/8/1.
 */
public class Main {
    private char[][] board;
    private boolean[][] visited;
    private int r, c;

    public void solve() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            r = scanner.nextInt();
            c = scanner.nextInt();
            board = new char[r][];
            visited = new boolean[r][c];
            for (int i = 0; i < r; i++) {
                board[i] = scanner.next().toCharArray();
            }
            int stR = scanner.nextInt();
            int stC = scanner.nextInt();
            int k = scanner.nextInt();
            int[] dr = new int[k];
            int[] dc = new int[k];
            for (int i = 0; i < k; i++) {
                dr[i] = scanner.nextInt();
                dc[i] = scanner.nextInt();
            }

            int maxCnt = 0;
            List<int[]> list = new LinkedList<>();
            List<int[]> list2 = new LinkedList<>();
            list.add(new int[]{stR, stC});
            visited[stR][stC] = true;
            while (!list.isEmpty()) {
                list2.clear();
                for (int[] pos : list) {
                    for (int i = 0; i < k; i++) {
                        int nr = pos[0] + dr[i];
                        int nc = pos[1] + dc[i];
                        if (nr < 0 || nr >= r || nc < 0 || nc >= c
                                || board[nr][nc] == 'X' || visited[nr][nc]) {
                            continue;
                        }
                        visited[nr][nc] = true;
                        list2.add(new int[]{nr,nc});
                    }
                }
                List<int[]> tmp = list;
                list = list2;
                list2 = tmp;
                maxCnt++;
            }

            boolean avail = true;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (!visited[i][j] && board[i][j] == '.') {
                        avail = false;
                        break;
                    }
                }
                if (!avail)
                    break;
            }

            System.out.println(avail ? maxCnt-1 : -1);
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}