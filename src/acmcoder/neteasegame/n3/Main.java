package acmcoder.neteasegame.n3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zkf on 9/18/16.
 */
public class Main {
    private void deal() {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int tt = 0; tt < t; tt++) {
            int n = scanner.nextInt();
            int l = scanner.nextInt();
            int[] nums = new int[l];
            for (int i = 0; i < l; i++) {
                nums[i] = scanner.nextInt();
            }

            boolean[] occ = new boolean[n];
            boolean canBeA = false;
            for (int st = 0; st < n; st++) {
                int idx = 0, ni = st;
                boolean curCanBeA = true;
                while (idx < l) {
                    for (; idx < l && ni < n; ni++) {
                        int num = nums[idx++] - 1;
                        if (occ[num]) {
                            curCanBeA = false;
                            break;
                        }
                        occ[num] = true;
                    }
                    if (!curCanBeA) break;
                    ni = 0;
                    Arrays.fill(occ, false);
                }

                if (curCanBeA) {
                    canBeA = true;
                    break;
                }
                Arrays.fill(occ, false);
            }

            if (canBeA) {
                System.out.println("CAN'T DECIDE");
            } else {
                System.out.println("B");
            }
        }
    }

    public static void main(String[] args) {
        new Main().deal();
    }
}
