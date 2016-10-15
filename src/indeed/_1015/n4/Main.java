package indeed._1015.n4;

import java.util.Scanner;

public class Main {
    private void deal() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if (n <= 2) {
                System.out.println(1.0);
                continue;
            }
            double[] dp = new double[n + 1];
            double curSum = 1.0;
            dp[1] = 1.0;
            dp[2] = 1.0;
            for (int i = 3; i <= n; i++) {
                dp[i] = curSum * 2 / i + 1;
                curSum += dp[i-1];
            }

            System.out.println(dp[n]);
        }
    }

    public static void main(String[] args) {
        new Main().deal();
    }
}

