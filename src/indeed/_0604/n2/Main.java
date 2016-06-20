package indeed._0604.n2;

import java.util.*;

/**
 * Created by Zhangkefei on 2016/6/4.
 */
public class Main {
    static Map<Long, Long> posMap = new HashMap<>();
    static int[] tens;
    static {
        tens = new int[10];
        int cur = 1;
        for (int i = 0; i < 9; i++) {
            tens[i] = cur;
            cur *= 10;
        }
    }
    static int len;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long s = scanner.nextLong(), m = scanner.nextLong();
        len = String.valueOf(s).length();
        posMap.put(s, 0l);
        List<Long> numList = new ArrayList<>();
        numList.add(s);
        for (long i = 1; i <= m; i++) {
            s = forward(s);
            Long prev = posMap.get(s);
            if (prev == null) {
                posMap.put(s, i);
                numList.add(s);
            }
            else {
                long pos = (m - prev) % (i - prev) + prev;
                System.out.println(numList.get((int)pos));
                return;
            }
        }
        System.out.println(s);
    }

    private static long forward(long num) {
        int first = (int)(num / tens[len-1]);
        num %= tens[len-1];
        long cut = tens[len-first];
        long left = num / cut, right = num % cut;
        return left * 10 * cut + first * cut + right;
    }
}
