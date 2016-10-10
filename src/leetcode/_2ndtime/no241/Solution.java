package leetcode._2ndtime.no241;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Whiteboard coding!
 */

public class Solution {
    private int len;
    private List<Integer>[][] cache;
    private String input;

    public List<Integer> diffWaysToCompute(String input) {
        if (input == null || (len = input.length()) == 0) return Collections.emptyList();
        this.input = input;
        cache = new List[len][len];
        compute(0, len-1);
        Collections.sort(cache[0][len-1]);
        return cache[0][len-1];
    }

    private List<Integer> compute(int st, int end) {
        if (cache[st][end] != null) return cache[st][end];

        List<Integer> res = new ArrayList<>();
        for (int i = st+1; i < end; i++) {
            char c = input.charAt(i);
            if ("+-*".indexOf(c) != -1) {
                res.addAll(combine(compute(st, i-1), compute(i+1, end), c));
            }
        }

        if (res.isEmpty()) {
            res.add(Integer.parseInt(input.substring(st, end+1)));
        }
        cache[st][end] = res;
        return res;
    }

    private List<Integer> combine(List<Integer> res1, List<Integer> res2, char c) {
        List<Integer> res = new ArrayList<>();
        for (int r1 : res1) {
            for (int r2 : res2) {
                switch (c) {
                    case '+': res.add(r1 + r2); break;
                    case '-': res.add(r1 - r2); break;
                    case '*': res.add(r1 * r2); break;
                }
            }
        }
        return res;
    }
}