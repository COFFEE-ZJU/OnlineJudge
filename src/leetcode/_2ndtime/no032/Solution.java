package leetcode._2ndtime.no032;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Whiteboard coding!
 */
public class Solution {
    public int longestValidParentheses(String s) {
        int len;
        if (s == null || (len = s.length()) <= 1) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int left = -1, max = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else {
                if (stack.isEmpty()) left = i;
                else {
                    stack.pop();
                    int prev = stack.isEmpty() ? left : stack.peek();
                    max = Math.max(max, i - prev);
                }
            }
        }

        return max;
    }
}