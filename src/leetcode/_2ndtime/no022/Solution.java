package leetcode._2ndtime.no022;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Whiteboard coding!
 */
public class Solution {
    private StringBuilder sb = new StringBuilder();
    private int n;
    private List<String> res;
    public List<String> generateParenthesis(int n) {
        if (n <= 0) return Collections.emptyList();

        this.n = n;
        res = new ArrayList<>();
        generate(0, 0);
        return res;
    }

    private void generate(int open, int close) {
        if (open + close == 2 * n) {
            res.add(sb.toString());
            return;
        }

        int oriLen = sb.length();
        if (open > close) {
            sb.append(')');
            generate(open, close+1);
            sb.setLength(oriLen);
        }
        if (open < n) {
            sb.append('(');
            generate(open+1, close);
            sb.setLength(oriLen);
        }
    }
}