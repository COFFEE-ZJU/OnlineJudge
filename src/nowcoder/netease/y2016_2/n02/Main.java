package nowcoder.netease.y2016_2.n02;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zkf on 3/17/16.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            long l = scanner.nextLong();
            long[] poses = new long[n];
            for (int i = 0; i < n; i++)
                poses[i] = scanner.nextLong();

            Arrays.sort(poses);
            long max2d = 2 * Math.max(poses[0]-0, l-poses[n-1]);
            for (int i = 1; i < n; i++) {
                long dest = poses[i]-poses[i-1];
                max2d = Math.max(max2d, dest);
            }

            System.out.println(String.format("%.2f", (double)(max2d) / 2));
        }
        scanner.close();
    }
}
