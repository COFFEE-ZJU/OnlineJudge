package nowcoder.mogujie.y2016.n01;

import java.util.Scanner;

/**
 * Created by zkf on 3/17/16.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int r = scanner.nextInt();
            int x0 = scanner.nextInt();
            int y0 = scanner.nextInt();
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            long dx = x1-x0, dy = y1-y0;
            long dist2 = dx*dx + dy*dy;
            long d2 = (long)r * r * 4;

            System.out.println((int)Math.ceil(Math.sqrt((double)dist2 / d2)));
        }
        scanner.close();
    }
}
