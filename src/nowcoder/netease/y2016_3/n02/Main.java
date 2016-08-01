package nowcoder.netease.y2016_3.n02;

/**
 * Created by Zhangkefei on 2016/8/1.
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int s = scanner.nextInt();
            int l = scanner.nextInt();

            l++;
            s++;
            int spcd = l / s;
            if (spcd % 13 == 0) spcd--;
            int res = n / spcd;
            int rem = n % spcd;
            if (rem != 0) {
                res++;
                if (rem % 13 == 0 && (res == 1 || rem + 1 == spcd))
                    res++;
            }

            System.out.println(res);
        }
    }
}