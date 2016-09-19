package leshi.n3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Zhangkefei on 2016/9/19.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String num = scanner.next();
            String num2 = scanner.next();
            if ("0".equals(num)) {
                System.out.println("0".equals(num2) ? "YES" : "NO");
                continue;
            }

            char[] cs = num.toCharArray();
            Arrays.sort(cs);
            swapNonZero(cs);
            String cmp = new String(cs);
            System.out.println(cmp.equals(num2) ? "YES" : "NO");
        }
    }

    private static void swapNonZero(char[] cs) {
        int i;
        for (i = 0; i < cs.length; i++) {
            if (cs[i] != '0') break;
        }
        char tmp = cs[0];
        cs[0] = cs[i];
        cs[i] = tmp;
    }
}
