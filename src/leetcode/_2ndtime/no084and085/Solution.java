package leetcode._2ndtime.no084and085;

import java.util.Stack;

/**
 * Whiteboard coding!
 */
public class Solution {
    private static class Rect {
        int hei, idx;
        Rect(int h, int i) {hei = h; idx = i;}
    }
    public int largestRectangleArea(int[] heights) {
        int len;
        if (heights == null || (len=heights.length) == 0) return 0;

        Stack<Rect> stack = new Stack<>();
        stack.push(new Rect(0, -1));
        stack.push(new Rect(heights[0], 0));
        int max = 0;
        for (int i = 1; i <= len; i++) {
            int curH = i == len ? 0 : heights[i];
            int idx = i;
            for (Rect rect = stack.peek(); rect.hei > curH; rect = stack.peek()) {
                stack.pop();
                idx = rect.idx;
                max = Math.max(max, rect.hei * (i - rect.idx));
            }
            stack.push(new Rect(curH, idx));
        }
        return max;
    }

    public int maximalRectangle(char[][] matrix) {
        int r, c;
        if (matrix == null || (r = matrix.length) == 0 || (c = matrix[0].length) == 0) return 0;

        int[] heights = new int[c];
        int max = 0;
        for (char[] line : matrix) {
            for (int i = 0; i < c; i++) {
                if (line[i] == '0') heights[i] = 0;
                else heights[i]++;
            }
            max = Math.max(max, largestRectangleArea(heights));
        }

        return max;
    }
}