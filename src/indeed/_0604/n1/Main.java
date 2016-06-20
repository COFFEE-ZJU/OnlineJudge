package indeed._0604.n1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Zhangkefei on 2016/6/4.
 */
public class Main {
    static List<String> all = new ArrayList<>(4*4*4 + 4*4 + 4);
    static int[] cnt = new int[4];

    static {
        StringBuilder sb = new StringBuilder(3);
        for (int i = 0; i < 4; i++) {
            sb.append((char)('a'+i));
            all.add(sb.toString());
            for (int j = 0; j < 4; j++) {
                sb.append((char)('a'+j));
                all.add(sb.toString());
                for (int k = 0; k < 4; k++) {
                    sb.append((char)('a'+k));
                    all.add(sb.toString());
                    sb.setLength(2);
                }
                sb.setLength(1);
            }
            sb.setLength(0);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ori = scanner.next();
        for (int i = 0; i < ori.length(); i++) {
            int pos = ori.charAt(i) - 'a';
            cnt[pos]++;
        }
        for (String pswd : all) {
            if (isUnsafe(ori, pswd))
                System.out.println(pswd);
        }
    }

    private static boolean isUnsafe(String ori, String pswd) {
        if (ori.length() != pswd.length()) return false;
        int cc = 0;
        int[] cnt2 = Arrays.copyOf(cnt, 4);
        for (int i = 0; i < pswd.length(); i++) {
            int pos = pswd.charAt(i) - 'a';
            if (cnt2[pos] == 0) cc++;
            else cnt2[pos]--;
        }

        return cc <= 1;
    }
}
