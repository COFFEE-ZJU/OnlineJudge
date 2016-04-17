package huawei.morning.n1;

import java.util.Scanner;

/**
 * Created by Zhangkefei on 2016/4/16.
 */
public class Main {

    public static int count(String sentence, String word) {
        int cnt = 0, st = 0;
        while (true) {
            st = sentence.indexOf(word, st);
            if (st == -1)
                return cnt;

            cnt++;
            st += word.length();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next(), w = scanner.next();
            System.out.println(count(s, w));
        }
    }
}
