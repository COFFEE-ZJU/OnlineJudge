package nowcoder.netease.y2016_1.n01;

import java.util.Scanner;

/**
 * Created by zkf on 3/17/16.
 */
public class Main {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextInt()) {
                int r = scanner.nextInt();
                int score = scanner.nextInt();
                for (int i = 0; i < r; i++) {
                    int b = scanner.nextInt();
                    if (score >= b) score += b;
                    else score += gcd(score, b);
                }
                System.out.println(score);
            }
        }
    }

    private static int gcd(int a, int b) {
        if (a % b == 0) return b;

        return gcd(b, a % b);
    }
}
