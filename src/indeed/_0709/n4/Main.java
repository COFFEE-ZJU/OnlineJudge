package indeed._0709.n4;

import java.util.Scanner;

/**
 * Created by Zhangkefei on 2016/7/2.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        int[] costs = new int[n+1];
        for (int i = 0; i <= n; i++) {
            costs[i] = scanner.nextInt();
        }

        long cost = 0;
        int match = 0, idx = 0;

        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (c == '(') match++;
            else match--;
            if (costs[i] < costs[idx]) idx = i;
            if (match < 0) {
                cost += costs[idx];
                match++;
            }
        }

        idx = n;
        match = 0;
        for (int i = n-1; i >= 0; i--) {
            char c = str.charAt(i);
            if (c == ')') match++;
            else match--;
            if (costs[i+1] < costs[idx]) idx = i+1;
            if (match < 0) {
                cost += costs[idx];
                match++;
            }
        }

        System.out.println(cost);

        scanner.close();
    }
}
