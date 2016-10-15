package indeed._1015.n2;

import java.util.Scanner;

public class Main {
    private void deal() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int[][] m1 = new int[a][b];
            int[][] m2 = new int[b][c];
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < b; j++) {
                    m1[i][j] = scanner.nextInt();
                }
            }
            for (int i = 0; i < b; i++) {
                for (int j = 0; j < c; j++) {
                    m2[i][j] = scanner.nextInt();
                }
            }
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < c; j++) {
                    System.out.print(calc(m1, m2, b, i, j));
                    if (j == c-1) System.out.println();
                    else System.out.print(' ');
                }
            }
        }
    }

    private long calc(int[][] m1, int[][] m2, int b, int i, int j) {
        long res = 0;
        for (int k = 0; k < b; k++) {
            res += m1[i][k] * m2[k][j];
        }
        return res;
    }

    public static void main(String[] args) {
        new Main().deal();
    }
}
