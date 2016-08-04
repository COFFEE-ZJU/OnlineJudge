package nowcoder.netease.y2016_4.n03;

/**
 * Created by Zhangkefei on 2016/8/1.
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            char[][] board = new char[r][];
            int[][] sums = new int[r][c];
            for (int i = 0; i < r; i++) {
                board[i] = scanner.next().toCharArray();
            }

            if (r < 4 || c < 4) {
                System.out.println(0);
                continue;
            }

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    int u = i == 0 ? 0 : sums[i-1][j];
                    int l = j == 0 ? 0 : sums[i][j-1];
                    int lu = (i==0 || j==0) ? 0 : sums[i-1][j-1];
                    sums[i][j] = u + l - lu + board[i][j] - '0';
                }
            }

            int[] is = new int[4];
            int[] js = new int[4];
            int maxMin = 0;
            for (is[0] = 0; is[0] < r - 3; is[0]++) {
                for (is[1] = is[0] + 1; is[1] < r - 2; is[1]++) {
                    for (is[2] = is[1] + 1; is[2] < r - 1; is[2]++) {
                        is[3] = r-1;
                        for (js[0] = 0; js[0] < c - 3; js[0]++) {
                            for (js[1] = js[0] + 1; js[1] < c - 2; js[1]++) {
                                for (js[2] = js[1] + 1; js[2] < c - 1; js[2]++) {
                                    js[3] = c-1;

                                    int min = Integer.MAX_VALUE;
                                    for (int i = 0; i < 4; i++) {
                                        for (int j = 0; j < 4; j++) {
                                            int u = i == 0 ? 0 : sums[is[i-1]][js[j]];
                                            int l = j == 0 ? 0 : sums[is[i]][js[j-1]];
                                            int lu = (i==0 || j==0) ? 0 : sums[is[i-1]][js[j-1]];
                                            int sum = sums[is[i]][js[j]] - u - l + lu;
                                            min = Math.min(min, sum);
                                        }
                                    }
                                    maxMin = Math.max(maxMin, min);
                                }
                            }
                        }
                    }
                }
            }

            System.out.println(maxMin);
        }
    }
}