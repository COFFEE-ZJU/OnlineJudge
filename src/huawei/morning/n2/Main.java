package huawei.morning.n2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Zhangkefei on 2016/4/16.
 */
public class Main {
    private static Set<String> wordsSet = new HashSet<>();

    public static String filter(String sentence) {
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split("[,. ]");

        wordsSet.clear();
        for (String w : words) {
            if (w.length() == 0 || !wordsSet.add(w))
                continue;

            sb.append(w).append(' ');
        }
        sb.setLength(sb.length()-1);
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            System.out.println(filter(scanner.nextLine()));
        }
    }
}
