package leetcode._2ndtime.no343;

import java.util.HashMap;
import java.util.Map;

/**
 * Whiteboard coding!
 *
 */
public class Solution {
    private Map<Integer, Integer> resMap = new HashMap<>();
    public int integerBreak(int n) {
        if (n <= 3) return n-1;
        resMap.put(1, 1);
        resMap.put(2, 2);
        resMap.put(3, 3);

        return calcMax(n);
    }

    private int calcMax(int n) {
        Integer cache = resMap.get(n);
        if (cache != null) return cache;
        int max = 0;
        for (int i = 2; i <= n / 2; i++) {
            max = Math.max(max, calcMax(i) * calcMax(n-i));
        }
        resMap.put(n, max);
        return max;
    }
}