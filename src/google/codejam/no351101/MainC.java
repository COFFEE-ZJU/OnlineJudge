package google.codejam.no351101;

import google.codejam.CodejamUtils;

import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

/**
 * Created by zkf on 3/24/16.
 */
public class MainC {
    public static final String fileName = "C-large-practice";

    private static final String[] numStrs = new String[]{
            "2", "22", "222",
            "3", "33", "333",
            "4", "44", "444",
            "5", "55", "555",
            "6", "66", "666",
            "7", "77", "777", "7777",
            "8", "88", "888",
            "9", "99", "999", "9999"
    };
    private static String getNumString(char c) {
        if (c == ' ') return "0";
        if (c < 'a' || c > 'z') throw new IllegalArgumentException();

        return numStrs[c-'a'];
    }

    public static void main(String[] args) throws IOException {
        try(Scanner scanner = CodejamUtils.getScanner(fileName, MainC.class);
            Writer writer = CodejamUtils.getWriter(fileName, MainC.class)) {
            int r = scanner.nextInt();
            scanner.nextLine();
            StringBuilder sb = new StringBuilder(200);
            for (int rr = 0; rr < r; rr++) {
                String line = scanner.nextLine();
                sb.setLength(0);
                char prev = 0;
                for (int i = 0; i < line.length(); i++) {
                    String toAppend = getNumString(line.charAt(i));
                    if (prev != 0 && prev == toAppend.charAt(0))
                        sb.append(' ');

                    sb.append(toAppend);
                    prev = toAppend.charAt(0);
                }

                writer.write(String.format("Case #%d: ", rr+1));
                writer.write(sb.toString());
                writer.write("\n");
            }
        }
    }
}
