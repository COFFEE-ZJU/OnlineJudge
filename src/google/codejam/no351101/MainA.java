package google.codejam.no351101;

import google.codejam.CodejamUtils;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zkf on 3/24/16.
 */
public class MainA {
    public static void main(String[] args) throws IOException {
        try(Scanner scanner = CodejamUtils.getScanner("A-small-practice", MainA.class);
            Writer writer = CodejamUtils.getWriter("A-small-practice", MainA.class)) {
            int r = scanner.nextInt();
            for (int rr = 0; rr < r; rr++) {
                int credit = scanner.nextInt();
                int n = scanner.nextInt();
                int[] prices = new int[n];
                for (int i = 0; i < n; i++)
                    prices[i] = scanner.nextInt();

                Arrays.sort(prices);
                int left = 0, right = n-1;
                while (left < right) {
                    int testc = prices[left] + prices[right];
                    if (testc == credit)
                        break;

                    if (testc < credit)
                        left++;
                    else
                        right--;
                }
                writer.write("Case #" + (rr+1) + ": ");
                if (left < right)
                    writer.write((left+1) + " " + (right+1) + "\n");
                else
                    System.out.println("not found\n");
            }
        }
    }
}
