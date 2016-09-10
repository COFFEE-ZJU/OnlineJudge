package leetcode._2ndtime.no347;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Whiteboard coding!
 */
public class Solution {
    private static class Count {
        int num, cnt=0;
        Count(int n) {num = n;}
    }

    private Map<Integer, Count> map = new HashMap<>();
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return Collections.emptyList();

        map.clear();
        for (int n : nums) {
            Count cnt = map.get(n);
            if (cnt == null) {
                cnt = new Count(n);
                map.put(n, cnt);
            }
            cnt.cnt++;
        }

        List<Count>[] cnts = new List[nums.length+1];
        for (Count cnt : map.values()) {
            List<Count> list = cnts[cnt.cnt];
            if (list == null) {
                list = new LinkedList<>();
                cnts[cnt.cnt] = list;
            }
            list.add(cnt);
        }

        List<Integer> res = new ArrayList<>(k);
        for (int i = nums.length; i > 0; i--) {
            List<Count> list = cnts[i];
            if (list == null) continue;
            for (Count cnt : list) {
                res.add(cnt.num);
                if (res.size() == k) return res;
            }
        }

        return res;
    }
}