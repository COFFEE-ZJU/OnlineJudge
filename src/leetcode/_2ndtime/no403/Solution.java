package leetcode._2ndtime.no403;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Whiteboard coding!
 */
public class Solution {
    private Map<Integer, Set<Integer>> kMap = new HashMap<>();
    public boolean canCross(int[] stones) {
        int len;
        if (stones == null || (len=stones.length) <= 1) return true;

        if (stones[1] != 1) return false;
        kMap.clear();
        kMap.put(1, Collections.singleton(1));
        for (int i = 2; i < len; i++) {
            kMap.put(stones[i], new HashSet<>());
        }

        for (int i = 1; i < len-1; i++) {
            Set<Integer> ks = kMap.get(stones[i]);
            if (ks == null || ks.isEmpty()) continue;

            for (int k : ks) {
                int next = stones[i]+k-1;
                Set<Integer> succKs;
                if (k > 1) {
                    succKs = kMap.get(next);
                    if (succKs != null) succKs.add(k-1);
                }
                next++;
                succKs = kMap.get(next);
                if (succKs != null) succKs.add(k);
                next++;
                succKs = kMap.get(next);
                if (succKs != null) succKs.add(k+1);
            }
        }

        return !kMap.get(stones[len-1]).isEmpty();
    }

    public static void main(String[] args) {
        new Solution().canCross(new int[]{0,1,3,4,5,7,9,10,12});
    }
}