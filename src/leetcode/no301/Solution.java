package leetcode.no301;

import java.util.*;

public class Solution {
    private Set<String> res;
    private String str;
    private int curMaxLen;

    public List<String> removeInvalidParentheses(String s) {
        if (s == null || s.length() == 0) return Collections.singletonList("");

        res = new HashSet<>();
        str = s;
        curMaxLen = 0;

        tryOut(0, new StringBuilder(), 0);

        if (res.isEmpty())
            return Collections.singletonList("");
        else
            return new ArrayList<>(res);
    }

    private void tryOut(int idx, StringBuilder prev, int leftParCnt) {
        int curLen = prev.length();
        if (idx == str.length()) {
            if (leftParCnt != 0) return;

            if (curLen == curMaxLen) {
                res.add(prev.toString());
            }
            else if (curLen > curMaxLen) {
                curMaxLen = curLen;
                res.clear();
                res.add(prev.toString());
            }

            return;
        }

        if (curLen + str.length() - idx < curMaxLen)
            return;

        char c = str.charAt(idx);
        if (c == '(') {
            prev.append(c);
            tryOut(idx+1, prev, leftParCnt+1);
            prev.setLength(curLen);
            tryOut(idx+1, prev, leftParCnt);
            prev.setLength(curLen);
        }
        else if (c == ')') {
            if (leftParCnt > 0) {
                prev.append(c);
                tryOut(idx + 1, prev, leftParCnt - 1);
                prev.setLength(curLen);
            }
            tryOut(idx + 1, prev, leftParCnt);
            prev.setLength(curLen);
        }
        else {
            prev.append(c);
            tryOut(idx + 1, prev, leftParCnt);
            prev.setLength(curLen);
        }
    }


    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.removeInvalidParentheses("()())"));
        System.out.println(sol.removeInvalidParentheses("("));
        System.out.println(sol.removeInvalidParentheses("x("));
    }
}
