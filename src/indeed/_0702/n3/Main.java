package indeed._0702.n3;

import java.util.Scanner;

/**
 * Created by Zhangkefei on 2016/7/2.
 */
public class Main {
    private static char[][] board = new char[6][6];
    private static int[] rowCnt = new int[6], colCnt = new int[6];
    private static int curCnt = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        curCnt = 0;
        for (int i = 0; i < 6; i++) {
            char[] line = scanner.nextLine().toCharArray();
            for (int j = 0; j < 6; j++) {
                board[i][j] = line[j];
                if (line[j] == 'o') {
                    curCnt++;
                    rowCnt[i]++;
                    colCnt[j]++;
                }
            }
        }

        int cnt = solve(0, 0);
        System.out.println(cnt);
    }

    private static int solve(int r, int c) {
        if (r >= 6) return curCnt == 18 ? 1 : 0;
        if (c >= 6) return solve(r+1, 0);

        if (rowCnt[r] > 3 || colCnt[c] > 3) return 0;
        if (rowCnt[r] == 3 || colCnt[c] == 3 || board[r][c] == 'o') return solve(r, c+1);
        int cnt = solve(r, c+1);
        curCnt++;
        rowCnt[r]++;
        colCnt[c]++;
        board[r][c] = 'o';
        cnt += solve(r, c+1);
        board[r][c] = '.';
        curCnt--;
        rowCnt[r]--;
        colCnt[c]--;

        return cnt;
    }

//    private static int countRow(int i) {
//        int cnt = 0;
//        for (int j = 0; j < 6; j++) {
//            if (board[i][j] == 'o' || board[i][j] == 'x') cnt++;
//        }
//        return cnt;
//    }
//
//    private static int countCol(int i) {
//        int cnt = 0;
//        for (int j = 0; j < 6; j++) {
//            if (board[j][i] == 'o' || board[j][i] == 'x') cnt++;
//        }
//        return cnt;
//    }
}
