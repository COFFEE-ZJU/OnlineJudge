package cn.edu.zju.coffee.nowcoder.mogujie.y2016.n04;

import java.util.Scanner;

/**
 * Created by zkf on 3/17/16.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(Long.MAX_VALUE);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int p = scanner.nextInt();
            int n = scanner.nextInt();
            boolean[] used = new boolean[p];
            boolean failed = false;
            for (int i = 0; i < n; i++) {
                int curP = (int) (scanner.nextLong() % p);
                if (failed) continue;
                if (used[curP]) {
                    System.out.println(i + 1);
                    failed = true;
                }
                used[curP] = true;
            }

            if (!failed)
                System.out.println(-1);
        }
        scanner.close();
    }
}
