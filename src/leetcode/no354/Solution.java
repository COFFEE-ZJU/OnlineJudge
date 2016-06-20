package leetcode.no354;

import java.util.*;

/**
 * Whiteboard coding!
 */
public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int len;
        if (envelopes == null || (len = envelopes.length) == 0) return 0;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o2[1] - o1[1];
                else return o1[0] - o2[0];
            }
        });

        int[] dp = new int[len];
        int max = 0;
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < len; i++) {
            int[] cur = envelopes[i];
            int idx = Arrays.binarySearch(dp, 0, i, cur[1]);
            if (idx < 0) {
                idx = -idx - 1;
                dp[idx] = cur[1];
                max = Math.max(max, idx);
            }
        }

        return max + 1;
    }


    /*
    N^2 version using dp
     */
    public int maxEnvelopes0(int[][] envelopes) {
        int len;
        if (envelopes == null || (len = envelopes.length) == 0) return 0;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int[] dp = new int[len];
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(dp[i], max);
        }

        return max+1;
    }
}