package nowcoder.huawei.n03;

import java.util.Scanner;

/**
 * Created by zkf on 3/17/16.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine().toLowerCase();
            int st = 0;
            if (str.startsWith("0x"))
                st = 2;

            long res = 0;
            for (int i = st; i < str.length(); i++) {
                char c = str.charAt(i);
                res *= 16;
                if (c >= 'a' && c <= 'z')
                    res += 10 + c - 'a';
                else
                    res += c - '0';
            }

            System.out.println(res);
        }
        scanner.close();
    }
}
