package nowcoder.didi.round2.n1;

import java.util.Scanner;

/**
 * Created by zkf on 9/18/16.
 */
public class Main {
    private void deal() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            System.out.println(solve(n));
        }
    }

    private int solve(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt += n / 5;
            n /= 5;
        }
        return cnt;
    }

    public static void main(String[] args) {
        new Main().deal();
    }
}
