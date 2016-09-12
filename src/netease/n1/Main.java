package netease.n1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Zhangkefei on 2016/9/11.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if (n <= 0) {
                System.out.println(0);
            } else if (n == 1) {
                System.out.println(3);
            } else if (n == 2) {
                System.out.println(9);
            } else {
                long[][] cnt = new long[3][3];
                for (long[] c : cnt) Arrays.fill(c, 1);

                long[][] next = new long[3][3];
                for (int i = 2; i < n; i++) {

                    for (long[] c : next) Arrays.fill(c, 0);
                    for (int j = 0; j < 3; j++) {
                        for (int k = 0; k < 3; k++) {
                            for (int l = 0; l < 3; l++) {
                                if (j == k || j == l || k == l)
                                    next[k][l] += cnt[j][k];
                            }
                        }
                    }

                    long[][] tmp = next;
                    next = cnt;
                    cnt = tmp;
                }

                long total = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        total += cnt[i][j];
                    }
                }
                System.out.println(total);
            }

        }
    }

}
