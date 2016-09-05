package jd.n2;

import java.util.Scanner;

/**
 * Created by Zhangkefei on 2016/9/5.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            System.out.println(solve(scanner.nextLong()));
        }
    }

    private static String solve(long k) {
        k++;
        long mask = 1;
        while (mask <= k) mask <<= 1;
        mask >>= 2;
        StringBuilder sb = new StringBuilder();
        while (mask != 0) {
            if ((mask & k) == 0)
                sb.append('4');
            else
                sb.append('7');
            mask >>= 1;
        }
        return sb.toString();
    }
}
