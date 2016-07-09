package indeed._0702.n3_2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Zhangkefei on 2016/7/2.
 */
public class Main {
    private static int[] board = new int[6];
    private static int[] colCnt;

    private static int[] choices = new int[]{7, 11, 13, 14, 19, 21, 22, 25, 26, 28, 35, 37, 38, 41, 42, 44, 49, 50, 52, 56};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            char[] line = scanner.nextLine().toCharArray();
            int num = 0;
            for (int j = 0; j < 6; j++) {
                if (line[j] == 'o') num += 1 << j;
            }
            board[i] = num;
        }

        colCnt = new int[6];
        int cnt = solve(0);
        System.out.println(cnt);
    }

    private static int solve(int r) {
        for (int i = 0; i < 6; i++) {
            if (colCnt[i] > 3) return 0;
        }
        if (r >= 6) return 1;

        int[] oldColCnt = Arrays.copyOf(colCnt, 6);
        int cnt = 0;
        for (int choice : choices) {
            if ((choice & board[r]) != board[r]) continue;
            for (int i = 0; i < 6; i++) {
                if ((choice & (1 << i)) != 0) {
                    colCnt[i]++;
                }
            }
            cnt += solve(r+1);
            for (int i = 0; i < 6; i++) {
                colCnt[i] = oldColCnt[i];
            }
        }

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
