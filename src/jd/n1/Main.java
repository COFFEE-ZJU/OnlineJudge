package jd.n1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Zhangkefei on 2016/9/5.
 */
public class Main {
    private static class Record implements Comparable<Record>{
        final int day, height;

        private Record(int day, int height) {
            this.day = day;
            this.height = height;
        }

        @Override
        public int compareTo(Record o) {
            return Integer.compare(day, o.day);
        }
    }
    private int n,m;
    private Record[] records;

    private void deal() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            records = new Record[m];
            for (int i = 0; i < m; i++) {
                records[i] = new Record(scanner.nextInt(), scanner.nextInt());
            }
            Arrays.sort(records);

            boolean possible = true;
            Record prev = records[0];
            int maxHeight = prev.height + prev.day - 1;
            for (int i = 1; i < m; i++) {
                Record cur = records[i];
                int period = cur.day - prev.day;
                int hDiff = Math.abs(cur.height - prev.height);
                int max = Math.max(cur.height, prev.height);
                period -= hDiff;
                if (period < 0) {
                    possible = false;
                    break;
                }
                maxHeight = Math.max(maxHeight, max + period/2);
                prev = cur;
            }
            if (possible) {
                maxHeight = Math.max(maxHeight, prev.height + (n - prev.day));
                System.out.println(maxHeight);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    public static void main(String[] args) {
        new Main().deal();
    }

}
