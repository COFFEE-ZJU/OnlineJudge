package indeed._0604.n4;

import java.util.*;

/**
 * Created by Zhangkefei on 2016/6/4.
 */
public class Main {
    static int[][] choco;
    static int totalW;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt(), c = scanner.nextInt();
        choco = new int[r][c];
        totalW = 0;
        for (int i = 0; i < r; i++) {
            String line = scanner.next();
            for (int j = 0; j < c; j++) {
                choco[i][j] = line.charAt(j) - '0';
                totalW += choco[i][j];
            }
        }
        int cost = minCost(0, 0, r-1, c-1, totalW);
        System.out.println(cost);
    }

    private static int minCost(int r0, int c0, int r1, int c1, int w) {
        if (r0 == r1 && c0 == c1) return choco[r0][c0];

        int maxMin = 0;
        int cur = 0, left;
        int p1, p2, w1, w2;
        p1 = p2 = -1;
        w1 = w2 = 0;
        for (int i = r0; i < r1; i++) {
            for (int j = c0; j <= c1; j++) {
                cur += choco[i][j];
            }
            left = w - cur;
            int min = Math.min(cur, left);
            if (min > maxMin) {
                maxMin = min;
                p1 = i;
                w1 = cur;
                continue;
            }
            else if (min == maxMin) {
                p2 = i;
                w2 = cur;
            }
            break;
        }

        int cost = Integer.MAX_VALUE;
        if (p1 != -1) {
            cost = minCost(r0, c0, p1, c1, w1) + minCost(p1+1, c0, r1, c1, w - w1);
        }
        if (p2 != -1) {
            cost = Math.min(cost,
                    minCost(r0, c0, p2, c1, w1) + minCost(p2 + 1, c0, r1, c1, w - w1));
        }

        maxMin = 0;
        cur = 0;
        p1 = p2 = -1;
        w1 = w2 = 0;
        for (int j = c0; j < c1; j++) {
            for (int i = r0; i <= r1; i++) {
                cur += choco[i][j];
            }
            left = w - cur;
            int min = Math.min(cur, left);
            if (min > maxMin) {
                maxMin = min;
                p1 = j;
                w1 = cur;
                continue;
            }
            else if (min == maxMin) {
                p2 = j;
                w2 = cur;
            }
            break;
        }

        if (p1 != -1) {
            cost = Math.min(cost,
                    minCost(r0, c0, r1, p1, w1) + minCost(r0, p1 + 1, r1, c1, w - w1));
        }
        if (p2 != -1) {
            cost = Math.min(cost,
                    minCost(r0, c0, r1, p2, w1) + minCost(r0, p2+1, r1, c1, w - w1));
        }

        return cost + w;
    }

}
