package leetcode._2ndtime.no071;

import java.util.Stack;

/**
 * Whiteboard coding!
 */
public class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return null;

        String[] vars = path.split("/");
        int len = vars.length;
        if (len == 0) return "/";
        if (!vars[0].isEmpty()) return null;

        Stack<String> stack = new Stack<>();
        for (int i = 1; i < len; i++) {
            String cur = vars[i];
            if (cur.isEmpty() || ".".equals(cur)) continue;
            if ("..".equals(cur)) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(cur);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String var : stack) {
            sb.append('/');
            sb.append(var);
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}