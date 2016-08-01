package nowcoder.netease.y2016_3.n01;

/**
 * Created by Zhangkefei on 2016/8/1.
 */
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    private int ii = 1;
    private class Inner {
        private void test() {
            System.out.println(ii);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();

            while (num != 6174 && num != 0) {
                char[] cs = (String.format("%04d", num)).toCharArray();
                Arrays.sort(cs);
                String bs = new String(cs);
                String as = new StringBuilder(new String(cs)).reverse().toString();
                num = Integer.parseInt(as) - Integer.parseInt(bs);
                System.out.printf("%s - %s = %04d\n", as, bs, num);
            }
        }
    }
}