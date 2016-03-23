package nowcoder.sohu.y2016.n02;

import java.util.*;

/**
 * Created by zkf on 3/17/16.
 */
public class Main {
    private static final Map<Character, Integer> valueMap = new HashMap<>();
    static {
        for (int i = 2; i < 10; i++)
            valueMap.put((char)('0' + i), i-1);
        valueMap.put('T', 9);
        valueMap.put('J', 10);
        valueMap.put('Q', 11);
        valueMap.put('K', 12);
        valueMap.put('A', 13);
    }

    private static int[] parse(String str) {
        if (str == null) return null;
        str = str.replace("10", "T");
        if (str.length() != 3) return null;

        int[] res = new int[3];
        for (int i = 0; i < 3; i++) {
            Integer val = valueMap.get(str.charAt(i));
            if (val == null) return null;
            res[i] = val;
        }
        Arrays.sort(res);
        return res;
    }

    private static int compare(int[] r1, int[] r2) {
        if (r1 == null || r2 == null)
            return -2;
        int v1 = getScore(r1), v2 = getScore(r2);
        if (v1 == -1 && v2 == -1) {
            for (int i = 2; i >= 0; i--) {
                if (r1[i] > r2[i]) return 1;
                else if (r1[i] < r2[i]) return -1;
            }
            return 0;
        }

        return v1 == v2 ? 0 : (v1 > v2 ? 1 : -1);
    }

    private static int getScore(int[] r) {
        if (r[0] == r[1] && r[1] == r[2])
            return r[0] * 1000000;

        if (r[0]+1 == r[1] && r[1]+1 == r[2])
            return r[0] * 10000;

        if (r[0] == r[1])
            return r[0] * 100 + r[2];

        if (r[1] == r[2])
            return r[1] * 100 + r[0];

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String a = scanner.next();
            String b = scanner.next();
            int[] r1 = parse(a), r2 = parse(b);

            System.out.println(compare(r1, r2));
        }
        scanner.close();
    }
}
