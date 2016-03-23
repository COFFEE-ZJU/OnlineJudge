package nowcoder.huawei.n01;

import java.util.Scanner;

/**
 * Created by zkf on 3/17/16.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if (n == 0) break;

            System.out.println(n / 2);
        }
        scanner.close();
    }
}
