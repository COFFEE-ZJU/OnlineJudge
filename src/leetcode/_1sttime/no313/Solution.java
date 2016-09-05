package leetcode._1sttime.no313;

import java.util.Arrays;

/**
 * Whiteboard coding!
 */
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int plen = primes.length;
        int[] idces = new int[plen], cand, ugly = new int[n];
        cand = Arrays.copyOf(primes, plen);

        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < plen; j++) {
                min = Math.min(min, cand[j]);
            }
            ugly[i] = min;
            for (int j = 0; j < plen; j++) {
                if (cand[j] == min)
                    cand[j] = ugly[++idces[j]] * primes[j];
            }
        }

        return ugly[n-1];
    }
}
