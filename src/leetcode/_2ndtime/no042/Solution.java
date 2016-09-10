package leetcode._2ndtime.no042;

import java.util.Stack;

/**
 * Whiteboard coding!
 */
public class Solution {
    private static class Bar {
        int height, width;
        Bar(int h) {
            this(h, 1);
        }
        Bar(int h, int w) {
            height = h;
            width = w;
        }
    }
    public int trap(int[] height) {
        int len;
        if (height == null || (len = height.length) <= 2) return 0;

        Stack<Bar> stack = new Stack<>();
        stack.push(new Bar(height[0]));
        int total = 0, maxH = height[0];
        for (int i = 1; i < len; i++) {
            int cur = height[i];
            int bound = Math.min(cur, maxH);
            int dw = 0;
            Bar bar = stack.pop();
            for (; bar.height < bound; bar = stack.pop()) {
                total += (bound - bar.height) * bar.width;
                dw += bar.width;
            }
            stack.push(bar);
            Bar newBar = new Bar(cur);
            stack.push(newBar);

            if (cur == bound) newBar.width += dw;
            else bar.width += dw;

            maxH = Math.max(cur, maxH);
        }

        return total;
    }
}