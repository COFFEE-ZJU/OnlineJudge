package indeed._0702.n3_3;

import java.util.Scanner;

/**
 * Created by Zhangkefei on 2016/7/2.
 */
public class Main {
    private static char[][] board = new char[6][6];
    private static int[] rowCnt = new int[6], colCnt = new int[6];
    private static int res;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            char[] line = scanner.nextLine().toCharArray();
            for (int j = 0; j < 6; j++) {
                board[i][j] = line[j];
                if (line[j] == 'o') {
                    rowCnt[i]++;
                    colCnt[j]++;
                }
            }
        }

        res = 0;
        solve(0);
        System.out.println(res);
    }

    private static void solve(int pos) {
        if (pos == 36) {
            for (int i = 0; i < 6; i++) {
                if (rowCnt[i] != 3 || colCnt[i] != 3)
                    return ;
            }
            res++;
            return;
        }
        int r = pos / 6, c = pos % 6;

        if (rowCnt[r] > 3 || colCnt[c] > 3) return;

        solve(pos+1);
        if (rowCnt[r] == 3 || colCnt[c] == 3 || board[r][c] == 'o') {
            return;
        }
        rowCnt[r]++;
        colCnt[c]++;
        solve(pos+1);
        rowCnt[r]--;
        colCnt[c]--;
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
