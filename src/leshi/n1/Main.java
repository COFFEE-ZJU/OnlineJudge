package leshi.n1;

import java.util.Scanner;

/**
 * Created by Zhangkefei on 2016/9/19.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = Math.abs(scanner.nextInt());
            if (n == 0) {
                System.out.println(0);
                continue;
            }

            int cur = 0, jmp;
            for (jmp = 1; ; jmp++) {
                cur += jmp;
                if (cur > n) break;
            }
            cur -= jmp;
            jmp--;

            int res = jmp + 2 * (n - cur);
            System.out.println(res);
        }
    }
}
