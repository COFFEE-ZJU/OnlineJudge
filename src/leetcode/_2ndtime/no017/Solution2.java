package leetcode._2ndtime.no017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Whiteboard coding! using backtracking
 */
public class Solution2 {
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

    private List<String> res;
    private String digits;
    private StringBuilder sb = new StringBuilder();
    private int len;
    public List<String> letterCombinations(String digits) {
        if (digits == null || (len=digits.length()) == 0) return Collections.emptyList();

        this.digits = digits;

        res = new ArrayList<>();
        generate(0);
        return res;
    }

    private void generate(int idx) {
        if (idx == len) {
            res.add(sb.toString());
            return;
        }

        char curC = digits.charAt(idx++);
        if (curC < '2' || curC > '9') {
            generate(idx);
            return;
        }

        int oriLen = sb.length();
        for (char c : cs[curC-'2']) {
            sb.append(c);
            generate(idx);
            sb.setLength(oriLen);
        }
    }
}