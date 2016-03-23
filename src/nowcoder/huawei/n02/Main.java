package nowcoder.huawei.n02;

import java.util.Scanner;

/**
 * Created by zkf on 3/17/16.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean[] ids = new boolean[1000];
        while (scanner.hasNextInt()) {
            int r = scanner.nextInt();
            for (int rr = 0; rr < r; rr++) {
                int n = scanner.nextInt() - 1;
                ids[n] = true;
            }
            for (int i = 0; i < 1000; i++) {
                if (ids[i]) {
                    ids[i] = false;
                    System.out.println(i+1);
                }
            }
        }
        scanner.close();
    }
}
