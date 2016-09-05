package leetcode._1sttime.no372;

import java.util.HashMap;
import java.util.Map;

/**
 * Whiteboard coding!
 */
public class Solution {
    private static Map<Integer, Map<Integer, Integer>> powXMod = new HashMap<>();

    public int superPow(int a, int[] b) {
        a %= 1337;
        int len;
        if (b == null || (len=b.length) == 0) return a;

        int mod = 1;
        for (int i = len-1; i >= 0; i--) {
            mod = mod * getPowXMod(a, b[i]) % 1337;
            a = getPowXMod(a, 10);
        }

        return mod;
    }

    private static int getPowXMod(int a, int x) {
        if (x == 0) return 1;
        a %= 1337;
        if (x == 1) return a;

        Map<Integer, Integer> cacheMap = powXMod.get(x);
        if (cacheMap == null) {
            cacheMap = new HashMap<>();
            powXMod.put(x, cacheMap);
        }

        Integer cache = cacheMap.get(a);
        if (cache != null) return cache;

        switch (x) {
            case 4:
                cache = getPowXMod(a, 2);
                cache = getPowXMod(cache, 2);
                break;
            case 6:
                cache = getPowXMod(a, 2);
                cache = getPowXMod(cache, 3);
                break;
            case 8:
                cache = getPowXMod(a, 4);
                cache = getPowXMod(cache, 2);
                break;
            case 9:
                cache = getPowXMod(a, 3);
                cache = getPowXMod(cache, 3);
                break;

        }

        if (cache == null) {
            int mod = 1;
            for (int i = 0; i < x; i++) {
                mod = mod * a % 1337;
            }
            cache = mod;
        }
        cacheMap.put(a, cache);
        return cache;
    }
}