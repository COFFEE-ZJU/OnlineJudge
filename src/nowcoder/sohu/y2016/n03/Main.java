package nowcoder.sohu.y2016.n03;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zkf on 3/17/16.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] scores = new int[n];
            int[] awards = new int[n];
            Arrays.fill(awards, 1);
            for (int i = 0; i < n; i++)
                scores[i] = scanner.nextInt();

            for (int i = 1; i < n; i++) {
                if (scores[i] > scores[i-1] && awards[i] <= awards[i-1])
                    awards[i] = awards[i-1] + 1;
            }
            for (int i = n-2; i >= 0; i--) {
                if (scores[i] > scores[i+1] && awards[i] <= awards[i+1])
                    awards[i] = awards[i+1] + 1;
            }

            int total = 0;
            for (int i = 0; i < n; i++)
                total += awards[i];
            System.out.println(total);
        }
        scanner.close();
    }
}
