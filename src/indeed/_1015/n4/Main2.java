package indeed._1015.n4;

import java.util.Scanner;

public class Main2 {
    private void deal() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if (n <= 2) {
                System.out.println(1.0);
                continue;
            }
            double[] dp = new double[n + 1];
            dp[1] = 1.0;
            dp[2] = 1.0;
            for (int i = 3; i <= n; i++) {
                int mid = i % 2 == 0 ? i / 2 - 1 : i / 2;
                double total = 0;
                for (int j = 0; j <= mid; j++) {
                    int left = j - 1 < 0 ? 0 : j - 1;
                    int right = i - j - 2 < 0 ? 0 : i - j - 2;
                    if (j == mid && i % 2 == 1) {
                        total += dp[left] + dp[right];
                    } else {
                        total += (dp[left] + dp[right]) * 2;
                    }
                }
                dp[i] = total / i + 1;
            }

            System.out.println(dp[n]);
        }
    }

    public static void main(String[] args) {
        new Main2().deal();
    }
}
