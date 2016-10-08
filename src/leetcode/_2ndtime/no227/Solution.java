package leetcode._2ndtime.no227;

/**
 * Whiteboard coding!
 */

public class Solution {
    public int calculate(String s) {
        if (s == null) return 0;
        s = s.replace(" ", "");
        int len = s.length();
        if (len == 0) return 0;

        int asPrev = 0, mdPrev = 1, cur = 0;
        char asOp = '+', mdOp = '*';
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                cur = cur * 10 + c - '0';
            } else if (c == '*' || c == '/') {
                mdPrev = apply(mdPrev, cur, mdOp);
                cur = 0;
                mdOp = c;
            } else {
                asPrev = apply(asPrev, apply(mdPrev, cur, mdOp), asOp);
                cur = 0;
                mdPrev = 1;
                mdOp = '*';
                asOp = c;
            }
        }
        return apply(asPrev, apply(mdPrev, cur, mdOp), asOp);
    }

    private int apply(int prev, int cur, char op) {
        switch (op) {
            case '+': return prev + cur;
            case '-': return prev - cur;
            case '*': return prev * cur;
            case '/': return prev / cur;
        }
        return 0;
    }
}