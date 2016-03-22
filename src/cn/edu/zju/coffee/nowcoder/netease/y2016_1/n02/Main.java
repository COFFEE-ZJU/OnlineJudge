package cn.edu.zju.coffee.nowcoder.netease.y2016_1.n02;

import java.util.Scanner;

/**
 * Created by zkf on 3/17/16.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int[] xs = new int[4];
            int[] ys = new int[4];
            double r = (double) scanner.nextInt();
            for (int i = 0; i < 4; i++) {
                xs[i] = scanner.nextInt();
                ys[i] = scanner.nextInt();
            }
            int hurt = 0;
            for (int i = 0; i < 3; i++) {
                int x = xs[3] - xs[i], y = ys[3] - ys[i];
                if (Math.sqrt(x * x + y * y) <= r) hurt++;
            }
            System.out.print(hurt + "x");
        }
    }
}
