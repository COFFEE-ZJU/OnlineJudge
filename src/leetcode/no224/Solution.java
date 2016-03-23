package leetcode.no224;

import java.util.Stack;

public class Solution {
    private Stack<Integer> stack = new Stack<>();

    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;

        char[] cs = s.toCharArray();

        stack.clear();
        int cur = 0, sign = 1;
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (c == ' ') continue;

            if (c >= '0' && c <= '9') {
                int num = c - '0';
                while (i+1 < cs.length && cs[i+1] >= '0' && cs[i+1] <= '9')
                    num = num * 10 + (cs[++i] - '0');

                cur += sign * num;
            }
            else if (c == '+')
                sign = 1;
            else if (c == '-')
                sign = -1;
            else if (c == '('){
                stack.push(cur);
                stack.push(sign);
                cur = 0; sign = 1;
            }
            else if (c == ')'){
                int cc = cur;
                sign = stack.pop();
                cur = stack.pop();
                cur += sign * cc;
            }
        }

        return cur;
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.calculate("1 + 1"));
        System.out.println(sol.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
