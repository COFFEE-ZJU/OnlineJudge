package acmcoder.neteasegame.n1;

import java.util.Scanner;

/**
 * Created by zkf on 9/18/16.
 */
public class Main {
    private void deal() {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int tt = 0; tt < t; tt++) {
            int k = scanner.nextInt();
            String str = scanner.next();
            System.out.println(solve(str, k));
        }
    }

    private int solve(String str, int k) {
        int len = str.length();
        if (len == 0) return 0;
        int[] dp = new int[k+1];
        int[] prev = new int[k+1];
        int max = 0;
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);

            if (c == '0') dp[0] = prev[0]+1;
            else dp[0] = 0;

            for (int j = 1; j <= k; j++) {
                if (c == '0') dp[j] = prev[j] + 1;
                else dp[j] = prev[j-1] + 1;
            }

            max = Math.max(max, dp[k]);
            int[] tmp = dp;
            dp = prev;
            prev = tmp;
        }
        return max;
    }

    public static void main(String[] args) {
        new Main().deal();
    }
}
