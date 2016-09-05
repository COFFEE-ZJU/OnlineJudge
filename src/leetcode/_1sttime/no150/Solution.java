package leetcode._1sttime.no150;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0)
            return 0;

        Stack<Integer> stack = new Stack<>();
        for (String tk : tokens){
            Character op = tryResolveOp(tk);
            if (op == null)
                stack.add(Integer.parseInt(tk));
            else {
                int b = stack.pop(), a = stack.pop();
                switch (op){
                    case '+': stack.push(a+b); break;
                    case '-': stack.push(a-b); break;
                    case '*': stack.push(a*b); break;
                    case '/': stack.push(a/b); break;
                }
            }
        }

        return stack.pop();
    }

    private Character tryResolveOp(String tk){
        if (tk.length() == 1){
            char c = tk.charAt(0);
            if (c == '+' || c == '-' || c == '*' || c == '/')
                return c;
        }

        return null;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }
}
