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
    private static class Pair implements Comparable<Pair>{
        int idx, val;

        public Pair(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(val, o.val);
        }
    }
    public static void main(String[] args) throws IOException {
        try(Scanner scanner = CodejamUtils.getScanner("A-large-practice", MainA.class);
            Writer writer = CodejamUtils.getWriter("A-large-practice", MainA.class)) {
            int r = scanner.nextInt();
            for (int rr = 0; rr < r; rr++) {
                int credit = scanner.nextInt();
                int n = scanner.nextInt();
                Pair[] prices = new Pair[n];
                for (int i = 0; i < n; i++)
                    prices[i] = new Pair(i+1, scanner.nextInt());

                Arrays.sort(prices);
                int left = 0, right = n-1;
                while (left < right) {
                    int testc = prices[left].val + prices[right].val;
                    if (testc == credit)
                        break;

                    if (testc < credit)
                        left++;
                    else
                        right--;
                }
                writer.write("Case #" + (rr+1) + ": ");
                if (left < right) {
                    int li = prices[left].idx, ri = prices[right].idx;
                    writer.write(Math.min(li, ri) + " " + Math.max(li, ri) + "\n");
                }
                else
                    writer.write("not found\n");
            }
        }
    }
}
