package cn.edu.zju.coffee.nowcoder.mogujie.y2016.n05;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by zkf on 3/17/16.
 */
public class Main {
    private static boolean isPara(StringBuilder sb) {
        int i = 0, j = sb.length()-1;
        while (i < j) {
            if (sb.charAt(i++) != sb.charAt(j--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Character> chars = new TreeSet<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int len = line.length();
            chars.clear();
            for (int i = 0; i < len; i++)
                chars.add(line.charAt(i));

            StringBuilder sb = new StringBuilder(line);
            boolean found = false;
            for (int i = 0; i <= len; i++) {
                sb.insert(i, ' ');
                for (char c : chars) {
                    sb.setCharAt(i, c);
                    if (isPara(sb)) {
                        found = true;
                        break;
                    }
                }
                sb.deleteCharAt(i);
                if (found)
                    break;
            }

            System.out.println(found ? "YES" : "NO");
        }
        scanner.close();
    }
}
