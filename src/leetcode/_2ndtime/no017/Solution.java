package leetcode._2ndtime.no017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Whiteboard coding!
 */
public class Solution {
    private static char[][] cs = new char[][] {
            "abc".toCharArray(),
            "def".toCharArray(),
            "ghi".toCharArray(),
            "jkl".toCharArray(),
            "mno".toCharArray(),
            "pqrs".toCharArray(),
            "tuv".toCharArray(),
            "wxyz".toCharArray(),
    };

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return Collections.emptyList();

        List<StringBuilder> list = new ArrayList<>();
        list.add(new StringBuilder());
        List<StringBuilder> next = new ArrayList<>();
        next.addAll(list);

        for (char c : digits.toCharArray()) {
            if (c == '0' || c == '1') continue;

            next.clear();
            char[] ccs = cs[c-'2'];
            for (int i = 0; i < ccs.length-1; i++) {
                for (StringBuilder ori : list) {
                    StringBuilder nsb = new StringBuilder(ori);
                    nsb.append(ccs[i]);
                    next.add(nsb);
                }
            }
            for (StringBuilder ori : list) {
                ori.append(ccs[ccs.length-1]);
                next.add(ori);
            }

            List<StringBuilder> tmp = list;
            list = next;
            next = tmp;
        }

        List<String> res = new ArrayList<>();
        for (StringBuilder ori : list) {
            res.add(ori.toString());
        }

        return res;
    }
}