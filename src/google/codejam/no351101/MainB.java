package google.codejam.no351101;

import google.codejam.CodejamUtils;

import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

/**
 * Created by zkf on 3/24/16.
 */
public class MainB {
    public static final String fileName = "B-large-practice";

    public static void main(String[] args) throws IOException {
        try(Scanner scanner = CodejamUtils.getScanner(fileName, MainB.class);
            Writer writer = CodejamUtils.getWriter(fileName, MainB.class)) {
            int r = scanner.nextInt();
            scanner.nextLine();
            for (int rr = 0; rr < r; rr++) {
                String line = scanner.nextLine();
                String[] ws = line.trim().split(" ");
                writer.write(String.format("Case #%d: ", rr+1));
                writer.write(ws[ws.length-1]);
                for (int i = ws.length-2; i >= 0 ; i--) {
                    writer.write(" ");
                    writer.write(ws[i]);
                }
                writer.write("\n");
            }
        }
    }
}
