package netease.n3;

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
            if (n < 6) {
                System.out.println(-1);
                continue;
            } else if (n == 6) {
                System.out.println(1);
                continue;
            }

            int[] dp = new int[n+1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            dp[6] = 1;
            for (int i = 8; i <= n; i+=2) {
                dp[i] = Math.min(dp[i-6], dp[i-8]);
                if (dp[i] != Integer.MAX_VALUE) dp[i]++;
            }

            System.out.println(dp[n] == Integer.MAX_VALUE ? -1 : dp[n]);
        }
    }
}
