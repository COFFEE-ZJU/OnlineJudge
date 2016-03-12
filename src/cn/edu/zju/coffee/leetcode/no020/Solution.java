package cn.edu.zju.coffee.leetcode.no020;

import java.util.Stack;

public class Solution {
    private Stack<Character> stack = new Stack<>();
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        stack.clear();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                char prev = stack.pop();
                if (c == ')' && prev != '(') return false;
                if (c == ']' && prev != '[') return false;
                if (c == '}' && prev != '{') return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
    }
}
