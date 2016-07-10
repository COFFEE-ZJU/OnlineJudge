package indeed._0709.n2;

import java.util.Scanner;

/**
 * Created by Zhangkefei on 2016/7/2.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong(), b = scanner.nextLong(), k = scanner.nextLong();

        long mcm = a == b ? 2 : minCommonMultiple(a, b);
        k %= (mcm / a + mcm / b);
        long taka = a, aoki = b;
        boolean isTaka = false;
        for (; k > 0; k--) {
            isTaka = taka <= aoki;
            if (isTaka) taka += a;
            else aoki += b;
        }
        if (isTaka)
            System.out.println("Takahashi");
        else
            System.out.println("Aoki");
        scanner.close();
    }

    public static long minCommonMultiple(long m, long n) {
        return m * n / maxCommonDivisor(m, n);
    }

    public static long maxCommonDivisor(long m, long n) {

        if (m < n) {
            long temp = m;
            m = n;
            n = temp;
        }
        while (m % n != 0) {
            long temp = m % n;
            m = n;
            n = temp;
        }
        return n;
    }
}
