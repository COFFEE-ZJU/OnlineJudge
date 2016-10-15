package indeed._1015.n3;

import java.util.Scanner;

public class Main {

    private int n, k;
    private long curRes, minDist;
    private int[] nums;
    private boolean[] occur;
    private void deal() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            occur = new boolean[n];
            curRes = 0;
            minDist = Long.MAX_VALUE;
            solve(0);

            System.out.println(minDist);
        }
    }

    private void solve(int idx) {
        if (idx == n) {
            minDist = Math.min(minDist, Math.abs(curRes - k));
            return;
        }

        long oriRes = curRes;
        for (int i = 0; i < n; i++) {
            if (occur[i]) continue;

            occur[i] = true;
            if (idx == 0){
                curRes = nums[i];
                solve(idx + 1);
            } else {
                curRes = oriRes + nums[i];
                solve(idx + 1);
                curRes = oriRes * nums[i];
                solve(idx + 1);
            }
            occur[i] = false;
        }

        curRes = oriRes;
    }

    private long calc(int[][] m1, int[][] m2, int b, int i, int j) {
        long res = 0;
        for (int k = 0; k < b; k++) {
            res += m1[i][k] * m2[k][j];
        }
        return res;
    }

    public static void main(String[] args) {
        new Main().deal();
    }
}
