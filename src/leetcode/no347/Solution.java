package leetcode.no347;

import java.util.*;

/**
 * Whiteboard coding!
 */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0)
            return Collections.emptyList();
        int len = nums.length;
        List<Integer>[] rankList = new List[len];
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int n : nums) {
            Integer cnt = countMap.get(n);
            cnt = cnt == null ? 1 : cnt+1;
            countMap.put(n, cnt);
        }
        for (Map.Entry<Integer, Integer> ent : countMap.entrySet()) {
            int cnt = ent.getValue() - 1, num = ent.getKey();
            if (rankList[cnt] == null)
                rankList[cnt] = new LinkedList<>();
            rankList[cnt].add(num);
        }

        List<Integer> res = new ArrayList<>(k);
        for (int i = len-1; i >= 0; i--) {
            if (rankList[i] == null)
                continue;
            for (Integer n : rankList[i]) {
                if (k == 0) break;
                res.add(n);
                k--;
            }
        }

        return res;
    }
}