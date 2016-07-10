package indeed._0709.n1;

import java.util.Scanner;

/**
 * Created by Zhangkefei on 2016/7/2.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next(), str2 = scanner.next();
        if (isPossible(str1, str2))
            System.out.println("Possible");
        else
            System.out.println("Impossible");

        scanner.close();
    }

    private static boolean isPossible(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        if (len1 != len2) return false;

        char a, b;
        a = b = 0;
        for (int i = 0; i < len1; i++) {
            char s1 = str1.charAt(i), s2 = str2.charAt(i);
            if (s1 == s2) continue;

            if (a == 0) {
                a = s1;
                b = s2;
            }
            else {
                if ((a == s1 && b == s2) || (b == s1 && a == s2))
                    continue;
                else
                    return false;
            }
        }
        return true;
    }
}
