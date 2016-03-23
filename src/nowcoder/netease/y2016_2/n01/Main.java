package nowcoder.netease.y2016_2.n01;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zkf on 3/17/16.
 */
public class Main {
    private static class Score implements Comparable<Score>{
        long effort, remain;

        public Score(long effort, long remain) {
            this.effort = effort;
            this.remain = remain;
        }

        @Override
        public int compareTo(Score o) {
            return Long.compare(effort, o.effort);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLong()) {
            long n = scanner.nextLong();
            long r = scanner.nextLong();
            long avg = scanner.nextLong();
            long total = n * avg;
            Score[] scores = new Score[(int)n];
            for (int i = 0; i < n; i++) {
                long a = scanner.nextLong();
                long b = scanner.nextLong();
                scores[i] = new Score(b, r-a);
                total -= a;
            }

            long eff = 0;
            if (total <= 0) {
                System.out.println(eff);
                continue;
            }

            Arrays.sort(scores);
            for (Score score : scores) {
                if (score.remain >= total) {
                    eff += score.effort * total;
                    break;
                }
                else {
                    eff += score.effort * score.remain;
                    total -= score.remain;
                }
            }

            System.out.println(eff);
        }
        scanner.close();
    }
}
