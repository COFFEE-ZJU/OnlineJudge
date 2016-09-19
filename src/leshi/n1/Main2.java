package leshi.n1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Zhangkefei on 2016/9/19.
 */
public class Main2 {
    private static Set<Integer> prev = new HashSet<>();
    private static Set<Integer> cur = new HashSet<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = Math.abs(scanner.nextInt());

            prev.clear();
            cur.clear();
            prev.add(0);
            for (int jmp = 1; ; jmp++) {
                if (prev.contains(n)) {
                    System.out.println(jmp-1);
                    break;
                }
                for (int pos : prev) {
                    int i1 = pos + jmp, i2 = Math.abs(pos - jmp);
                    if (i1 <= n) cur.add(i1);
                    if (i2 <= n) cur.add(i2);
                }
                Set<Integer> t = cur;
                cur = prev;
                prev = t;
                cur.clear();
            }
        }
    }
}
