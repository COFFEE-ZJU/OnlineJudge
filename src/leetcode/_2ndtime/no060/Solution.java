package leetcode._2ndtime.no060;

/**
 * Whiteboard coding!
 */
public class Solution {
    public String getPermutation(int n, int k) {
        if (n <= 0) return "";
        k--;
        int cnt = fact(n-1);
        int cur = n-1;
        StringBuilder sb = new StringBuilder();
        boolean[] occr = new boolean[n];
        for (int i = 0; i < n; i++) {
            int idx = k / cnt;
            for (int ii = 0, j = 0; j < n; j++) {
                if (occr[j]) continue;

                if (ii == idx) {
                    occr[j] = true;
                    sb.append(j+1);
                    break;
                }
                ii++;
            }

            k %= cnt;
            if (cur > 0) cnt /= cur;
            cur--;
        }
        return sb.toString();
    }

    private int fact(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }
}