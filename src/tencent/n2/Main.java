package tencent.n2;

import java.util.Scanner;

/**
 * Created by Zhangkefei on 2016/9/11.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int left = -90, right = 90;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                int mid = (left + right) / 2;
                if (n < mid) {
                    right = mid;
                    sb.append('0');
                } else {
                    left = mid;
                    sb.append('1');
                }
            }
            System.out.println(sb.toString());
        }
    }
}
